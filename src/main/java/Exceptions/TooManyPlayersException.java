package main.java.Exceptions;

import main.java.Server.Game;

public class TooManyPlayersException extends Exception {
    public Game game;

    public TooManyPlayersException(Game game) {
        this.game = game;
        System.out.println("An attempt was made to add too many players to " + game + ".");
    }
}
