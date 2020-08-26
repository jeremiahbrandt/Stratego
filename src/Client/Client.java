package Client;

import Protocol.Request;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Application {
    private static String ipAddress;
    private static int portNumber;

    private Socket socket;
    private ObjectOutputStream out;
    private Listener listener;
    private Thread listenerThread;

    private BoardView boardView;

    public static void main(String[] args) {
        try {
            ipAddress = args[0];
            portNumber = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Correct usage: \"java -jar Client.jar <ip_address> <port_number>\"");
            System.exit(1);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        boardView = new BoardView(this);
        connectToServer();
        primaryStage.setTitle("Stratego | Client.Client");
        primaryStage.setScene(new Scene(boardView, 750, 750));
        primaryStage.show();
    }

    public void sendRequest(Request req) {
        try {
            out.writeObject(req);
        } catch (IOException e) {
            System.out.println("There was a problem sending " + req + " through " + out + ".");
            e.printStackTrace();
        }
    }

    private void connectToServer() {
        try {
            socket = new Socket(ipAddress, portNumber);
            out = new ObjectOutputStream(socket.getOutputStream());
            listener = new Listener(boardView, new ObjectInputStream(socket.getInputStream()));
            listenerThread = new Thread(listener);
            listenerThread.start();
            System.out.println("Successfully connected to the server.");
        } catch (IOException e) {
            System.out.println("There was a problem connecting to the server.");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
