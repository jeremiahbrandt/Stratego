package Client;

import Client.Views.BoardView;
import Client.Views.GameView;
import Protocol.BoardPacket;
import Protocol.Message;
import Protocol.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Listener implements Runnable {
    private GameView gameView;
    private ObjectInputStream in;

    public Listener(GameView gameView, ObjectInputStream in) {
        this.gameView = gameView;
        this.in = in;
    }

    @Override
    public void run() {
        Packet res;
        while (true) {
            try {
                res = (Packet) in.readObject();
                if(res instanceof BoardPacket) {
                    gameView.displayBoard((BoardPacket) res);
                } else if (res instanceof Message) {
                    gameView.displayMessage((Message) res);
                }
                System.out.println(res + " received " + in + ".");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
