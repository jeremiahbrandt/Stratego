package Server;

import Exceptions.TooManyPlayersException;
import Protocol.BoardPacket;
import Server.Piece.APiece;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<ClientConnection> connections;
    private List<Square> board;
    private boolean isStarted;
    private ClientConnection currentPlayer;

    public Game() {
        connections = new ArrayList<ClientConnection>();
        board = new ArrayList<Square>();
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
        String[][] squares = new String[10][10];

        for(APiece piece: connection.getArmy()) {
            squares[piece.getLocation().col][piece.getLocation().row] = piece.toString();
        }

        for(ClientConnection opponentConnection: connections) {
            if(opponentConnection != connection) {
                for(APiece piece: opponentConnection.getArmy()) {
                    squares[piece.getLocation().col][piece.getLocation().row] = "?";
                }
            }
        }

        connection.sendBoard(new BoardPacket(squares));
    }

    private void createSquares() {
        for(int i=0; i<100; i++) {
            board.add(new Square());
        }
    }
}
