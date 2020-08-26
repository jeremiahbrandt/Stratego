package Server;

import Protocol.BoardPacket;
import Protocol.Request;
import Protocol.Response;
import Protocol.SquarePacket;
import Server.Piece.APiece;
import Server.Piece.PieceFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientConnection implements Runnable {
    private final Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private List<APiece> army;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        army = new ArrayList<>();
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        joinGame();

        while (true) {
            try {
                Request req = (Request) in.readObject();
                System.out.println(req + " received from " + socket + ".");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("There was a problem receiving a request from " + socket + ".");
                e.printStackTrace();
            }
        }
    }

    public void sendBoard(BoardPacket boardPacket) {


        try {
            out.writeObject(boardPacket);
        } catch (IOException e) {
            System.out.println("There was a problem sending the board to " + this + ".");
            e.printStackTrace();
        }
    }

    public void sendResponse(Response response) {
        try {
            out.writeObject(response);
        } catch (IOException e) {
            System.out.println("There was a problem sending " + response + " to the clients");
            e.printStackTrace();
        }
    }

    public List<APiece> getArmy() {
        return army;
    }

    public void createArmy(List<SquarePacket> startingSquarePackets) {
        PieceFactory pieceFactory = new PieceFactory();

        for(SquarePacket currentSquarePacket : startingSquarePackets) {
            army.add(pieceFactory.getNextPiece(currentSquarePacket));
        }
    }

    private void joinGame() {

    }
}
