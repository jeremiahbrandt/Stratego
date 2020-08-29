package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class Marshall extends APiece {
    public Marshall(SquarePacket squarePacket) {
        super("Marshall", 10, new NormalMoveValidator(), squarePacket);
        super.setShortName("10");
    }
}
