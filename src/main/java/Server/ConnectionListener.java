package main.java.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionListener implements Runnable {
    private final ServerSocket server;

    private List<Thread> connections;
    private GamesManager gamesManager;

    private boolean listening;

    public ConnectionListener(ServerSocket server) {
        this.server = server;
        connections = new ArrayList<>();
        gamesManager = new GamesManager();
    }

    @Override
    public void run() {
        System.out.println("main.java.Server is listening to for new client connections.");
        listening = true;
        while(listening) {
            try {
                Socket socket = server.accept();
                ClientConnection clientConnection = new ClientConnection(socket);
                gamesManager.addClient(clientConnection);
                Thread thread = new Thread(clientConnection);
                thread.start();
                connections.add(thread);
                System.out.println("New client connected " + socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
