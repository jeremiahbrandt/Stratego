package main.java.Protocol.Piece;

import main.java.Server.Move.StationaryMoveValidator;
import main.java.Protocol.SquarePacket;

public class Bomb extends APiece {
    public Bomb(SquarePacket squarePacket) {
        super("Bomb", 12, new StationaryMoveValidator(), squarePacket);
        super.setShortName("B");
    }
}
