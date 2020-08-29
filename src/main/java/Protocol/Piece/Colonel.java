package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class Colonel extends APiece {
    public Colonel(SquarePacket squarePacket) {
        super("Colonel", 8, new NormalMoveValidator(), squarePacket);
        super.setShortName("8");
    }
}
