package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionListener implements Runnable {
    private final ServerSocket server;

    private List<Thread> connections;
    private GamesManager gamesManager;

    public ConnectionListener(ServerSocket server) {
        this.server = server;
        connections = new ArrayList<Thread>();
        gamesManager = new GamesManager();
    }

    @Override
    public void run() {
        System.out.println("Server is listening to for new client connections.");
        while(true) {
            try {
                Socket socket = server.accept();
                ClientConnection clientConnection = new ClientConnection(socket);
                Thread thread = new Thread(clientConnection);
                thread.start();
                connections.add(thread);
                gamesManager.addClient(clientConnection);
                System.out.println("New client connected " + socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
