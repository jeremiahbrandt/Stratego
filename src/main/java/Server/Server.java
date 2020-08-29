package main.java.Server;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Application {
    private ServerSocket server;
    private static int portNumber;
    private Thread connectionListener;

    public static void main(String[] args) {
        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Correct usage: \"java -jar main.java.Server.jar <port_number>\"");
            System.exit(1);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stratego | main.java.Server.main.java.Server");
        primaryStage.setScene(new Scene(new BorderPane(), 500, 500));
//        primaryStage.show();

        startServer();
    }

    private void startServer() {
        try {
            server = new ServerSocket(portNumber);
            System.out.println("main.java.Server started on port " + portNumber + ".");
            connectionListener = new Thread(new ConnectionListener(server));
            connectionListener.start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There was a problom starting the server on port " + portNumber + ".");
            System.exit(1);
        }

    }
}
