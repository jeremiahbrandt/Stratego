package Server;

import Exceptions.TooManyPlayersException;
import Protocol.BoardPacket;
import Protocol.SquarePacket;
import Server.Piece.APiece;
import Server.Piece.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<ClientConnection> connections;
    private List<SquarePacket> board;
    private boolean isStarted;
    private ClientConnection currentPlayer;

    public Game() {
        connections = new ArrayList<>();
        board = new ArrayList<>();
        isStarted = false;
        createSquares();
    }

    public void addConnection(ClientConnection connection) throws TooManyPlayersException {
        if(connections.size() >= 2) {
            throw new TooManyPlayersException(this);
        } else {
            connections.add(connection);
            if(connections.size() == 2) {
                connection.createArmy(board.subList(60, 100));
                start();
            } else {
                connection.createArmy(board.subList(0, 40));
                currentPlayer = connection;
            }
        }

        for(ClientConnection player: connections) {
            sendBoard(player);
        }
    }

    public boolean isStarted() {
        return isStarted;
    }

    private void start() {
        isStarted = true;
    }

    private void sendBoard(ClientConnection connection) {
        BoardPacket boardPacket = new BoardPacket();

        boardPacket.addArmy(connection.getArmy());

        for(ClientConnection opponentConnection: connections) {
            if(opponentConnection != connection) {
                for(APiece piece: opponentConnection.getArmy())  {
                    boardPacket.addPiece(new Enemy(piece.getLocation()));
                }
            }
        }

        connection.sendBoard(boardPacket);
    }

    private void createSquares() {
        for(int i=0; i<100; i++) {
            board.add(new SquarePacket());
        }
    }
}
