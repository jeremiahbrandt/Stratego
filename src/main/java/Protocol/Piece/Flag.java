package main.java.Protocol.Piece;

import main.java.Server.Move.StationaryMoveValidator;
import main.java.Protocol.SquarePacket;

public class Flag extends APiece {
    public Flag(SquarePacket squarePacket) {
        super("Flag", 0, new StationaryMoveValidator(), squarePacket);
        super.setShortName("F");
    }
}
