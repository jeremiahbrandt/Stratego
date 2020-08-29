package Protocol.Piece;

import Server.Move.NormalMoveValidator;
import Protocol.SquarePacket;

public class Miner extends APiece {
    public Miner(SquarePacket squarePacket) {
        super("Miner", 3, new NormalMoveValidator(), squarePacket);
        super.setShortName("M");
    }
}
