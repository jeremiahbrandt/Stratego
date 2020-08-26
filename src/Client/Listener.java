package Client;

import Protocol.BoardPacket;
import Protocol.MovePacket;
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
        while (true) {
            try {
                Packet res = (Packet) in.readObject();
                System.out.println();
                if(res instanceof BoardPacket) {
                    boardView.displayBoard((BoardPacket) res);
                } else if(res instanceof MovePacket) {
                    boardView.displayMoves((MovePacket) res);
                }
                System.out.println(res + " received " + in + ".");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
