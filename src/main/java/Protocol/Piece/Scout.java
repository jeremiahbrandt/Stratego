package main.java.Protocol.Piece;

import main.java.Server.Move.ScoutMoveValidator;
import main.java.Protocol.SquarePacket;

public class Scout extends APiece {
    public Scout(SquarePacket squarePacket) {
        super("Scout", 2, new ScoutMoveValidator(), squarePacket);
        super.setShortName("2");
    }
}
