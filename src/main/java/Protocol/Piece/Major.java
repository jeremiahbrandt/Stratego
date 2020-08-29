package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class Major extends APiece {
    public Major(SquarePacket squarePacket) {
        super("Major", 7, new NormalMoveValidator(), squarePacket);
        super.setShortName("7");
    }
}
