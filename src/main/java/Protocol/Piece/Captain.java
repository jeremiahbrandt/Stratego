package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class Captain extends APiece {
    public Captain(SquarePacket squarePacket) {
        super("Captain", 6, new NormalMoveValidator(), squarePacket);
        super.setShortName("6");
    }
}
