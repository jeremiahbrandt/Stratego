package Client;

import Client.Views.BoardView;
import Protocol.BoardPacket;
import Protocol.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Listener implements Runnable {
    private BoardView boardView;
    private ObjectInputStream in;

    public Listener(BoardView boardView, ObjectInputStream in) {
        this.boardView = boardView;
        this.in = in;
    }

    @Override
    public void run() {
        Packet res;
        while (true) {
            try {
                res = (Packet) in.readObject();
                if(res instanceof BoardPacket) {
                    boardView.displayBoard((BoardPacket) res);
                }
                System.out.println(res + " received " + in + ".");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
