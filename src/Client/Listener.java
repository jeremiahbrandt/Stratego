package Client;

import Protocol.BoardPacket;
import Protocol.MovePacket;
import Protocol.Packet;
import Protocol.Response;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Listener implements Runnable {
    private Board board;
    private ObjectInputStream in;

    public Listener(Board board, ObjectInputStream in) {
        this.board = board;
        this.in = in;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Packet res = (Packet) in.readObject();
                if(res instanceof BoardPacket) {
                    System.out.println("Board");
                    board.displayBoard((BoardPacket) res);
                } else if(res instanceof MovePacket) {
                    System.out.println("Move");
                }
                System.out.println(res + " received " + in + ".");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
