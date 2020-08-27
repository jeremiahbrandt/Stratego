package Server;

import Exceptions.TooManyPlayersException;
import Protocol.BoardPacket;
import Protocol.Request;
import Protocol.SquarePacket;
import Protocol.Piece.APiece;
import Protocol.Piece.Enemy;
import Server.Move.Attack;

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

    public void handleMove(ClientConnection connection, Request req) {
        if(!isStarted) {
            return;
        }

        if(connection != currentPlayer) {
            return;
        }

        APiece attacker = null;
        for(APiece piece: connection.getArmy()) {
            if(piece.getLocation().row == req.previousLocation.row && piece.getLocation().col == req.previousLocation.col) {
                attacker = piece;
            }
        }
        if(attacker == null) {
            return;
        }

        APiece defender = null;;
        ClientConnection opponent = getOpponent(connection);
        for(APiece piece: opponent.getArmy()) {
            if(piece.getLocation().row == req.newLocation.row && piece.getLocation().col == req.newLocation.col) {
                defender = piece;
            }
        }

        boolean isLegalMove = attacker.getMoveValidator().isValidMove(req.previousLocation, req.newLocation);
        if(!isLegalMove) {
            return;
        }

        if(defender == null) {
            attacker.setLocation(req.newLocation);
        } else {
            Attack attack = new Attack(attacker, defender);
            if(attack.getWinner() == attacker) {
                attacker.setLocation(req.newLocation);
                defender.capture();
            } else if(attack.getWinner() == defender) {
                attacker.capture();
            }
        }

        nextTurn();
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

        for(APiece piece: connection.getArmy()) {
            if(!piece.getIsCaptured()) {
                boardPacket.addPiece(piece);
            }
        }

        ClientConnection opponent = getOpponent(connection);
        if(opponent != null) {
            for(APiece piece: getOpponent(connection).getArmy())  {
                if(!piece.getIsCaptured()) {
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

    private ClientConnection getOpponent(ClientConnection connection) {
        for (ClientConnection opponentConnection : connections) {
            if (opponentConnection != connection) {
                return opponentConnection;
            }
        }
        return null;
    }

    private void nextTurn() {
        for(ClientConnection clientConnection: connections) {
            sendBoard(clientConnection);
        }

        for(ClientConnection clientConnection: connections) {
            if(clientConnection != currentPlayer) {
                currentPlayer = clientConnection;
                break;
            }
        }
    }
}
