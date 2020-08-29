package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class Spy extends APiece {
    public Spy(SquarePacket squarePacket) {
        super("Spy", 1, new NormalMoveValidator(), squarePacket);
        super.setShortName("S");
    }
}
