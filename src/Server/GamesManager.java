package Server;

import Exceptions.TooManyPlayersException;

import java.util.ArrayList;
import java.util.List;

public class GamesManager {
    private List<Game> games;

    public GamesManager() {
        games = new ArrayList<Game>();
    }

    public void addClient(ClientConnection clientConnection) {
        if(games.size() == 0) {
            games.add(new Game());
        }

        if(games.get(games.size()-1).isStarted()) {
            games.add(new Game());
        }
        Game currentGame = games.get(games.size()-1);

        try {
            currentGame.addConnection(clientConnection);
        } catch (TooManyPlayersException e) {
            System.out.println("Unable to add " + clientConnection + " to " + currentGame + ".");
        }
    }
}
