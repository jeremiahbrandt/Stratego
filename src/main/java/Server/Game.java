package main.java.Server;

import main.java.Exceptions.TooManyPlayersException;
import main.java.Protocol.*;
import main.java.Protocol.Piece.APiece;
import main.java.Protocol.Piece.Enemy;
import main.java.Protocol.Piece.Flag;
import main.java.Server.Move.Attack;

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

        APiece defender = null;
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
                currentPlayer.sendChatMessage(new Message("main/java/Server", attack.getWinnerMessage()));
                getOpponent(currentPlayer).sendChatMessage(new Message("main/java/Server", attack.getLoserMessage()));
                attacker.setLocation(req.newLocation);
                defender.capture();
            } else if(attack.getWinner() == defender) {
                currentPlayer.sendChatMessage(new Message("main/java/Server", attack.getLoserMessage()));
                getOpponent(currentPlayer).sendChatMessage(new Message("main/java/Server", attack.getWinnerMessage()));
                attacker.capture();
            }
        }

        nextTurn();
        if(defender instanceof Flag) {
            currentPlayer.sendGameStatus(new GameStatus("Game over, your lost!"));
            getOpponent(currentPlayer).sendGameStatus(new GameStatus("Game over, your won!"));
        }
    }

    public void addConnection(ClientConnection connection) throws TooManyPlayersException {
        if(connections.size() >= 2) {
            throw new TooManyPlayersException(this);
        } else {
            connections.add(connection);
            if(connections.size() == 2) {
                connection.createArmy(board.subList(60, 100));
                connection.sendChatMessage(new Message("main/java/Server", "Welcome to Stratego! The game will now begin. It is your opponent's turn to move."));
                connection.sendGameStatus(new GameStatus("It is your opponent's turn to move."));
                currentPlayer.sendChatMessage(new Message("main/java/Server", "You opponent joined the game! It is your turn to move."));
                currentPlayer.sendGameStatus(new GameStatus("Your opponent joined the game. It is your turn to move."));
                start();
            } else {
                connection.createArmy(board.subList(0, 40));
                connection.sendChatMessage(new Message("main/java/Server", "Welcome to Stratego! Please wait until your opponent connects."));
                connection.sendGameStatus(new GameStatus("Waiting to opponent to connect..."));
                currentPlayer = connection;
            }
        }

        for(ClientConnection player: connections) {
            sendBoard(player);
        }
    }

    public void broadcastMessage(ClientConnection senderConnection, Message message) {
        senderConnection.sendChatMessage(new Message("You", message.getMsg()));
        getOpponent(senderConnection).sendChatMessage(new Message("Opponent", message.getMsg()));
    }

    public boolean isStarted() {
        return isStarted;
    }

    private void start() {
        isStarted = true;
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
            sendGameStatus(clientConnection);
        }

        for(ClientConnection clientConnection: connections) {
            if(clientConnection != currentPlayer) {
                currentPlayer = clientConnection;
                break;
            }
        }
    }

    private void sendGameStatus(ClientConnection connection) {
        if(connection == currentPlayer) {
            connection.sendGameStatus(new GameStatus("Waiting to opponent to move."));
        } else {
            connection.sendGameStatus(new GameStatus("Your turn to move."));
        }
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
}
