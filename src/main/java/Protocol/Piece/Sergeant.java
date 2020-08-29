package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class Sergeant extends APiece {
    public Sergeant(SquarePacket squarePacket) {
        super("Sergeant", 4, new NormalMoveValidator(), squarePacket);
        super.setShortName("4");
    }
}
