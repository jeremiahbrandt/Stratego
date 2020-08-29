package main.java.Protocol.Piece;

import main.java.Server.Move.NormalMoveValidator;
import main.java.Protocol.SquarePacket;

public class Miner extends APiece {
    public Miner(SquarePacket squarePacket) {
        super("Miner", 3, new NormalMoveValidator(), squarePacket);
        super.setShortName("M");
    }
}
