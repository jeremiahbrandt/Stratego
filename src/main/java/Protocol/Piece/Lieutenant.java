package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;
public class Lieutenant extends APiece {
    public Lieutenant(SquarePacket squarePacket) {
        super("Lieutenant", 5, new NormalMoveValidator(), squarePacket);
        super.setShortName("5");
    }
}
