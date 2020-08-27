package Client;

import Protocol.BoardPacket;
import Protocol.Packet;
import Protocol.SquarePacket;

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
                //TODO: Remove test
//                for(SquarePacket squarePacket: res.s)
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
