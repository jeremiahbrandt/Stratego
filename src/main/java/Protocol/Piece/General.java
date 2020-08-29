package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class General extends APiece {
    public General(SquarePacket squarePacket) {
        super("General", 9, new NormalMoveValidator(), squarePacket);
        super.setShortName("9");
    }
}
