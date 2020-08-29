package main.java.Protocol.Piece;

import main.java.Protocol.SquarePacket;
import main.java.Server.Move.StationaryMoveValidator;

public class Enemy extends APiece {
    public Enemy(SquarePacket squarePacket) {
        super("Enemy", -1, new StationaryMoveValidator(), squarePacket);
        super.setShortName("?");
    }
}
