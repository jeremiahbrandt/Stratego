package Protocol.Piece;

import Server.Move.NormalMoveValidator;
import Protocol.SquarePacket;

public class Colonel extends APiece {
    public Colonel(SquarePacket squarePacket) {
        super("Colonel", 8, new NormalMoveValidator(), squarePacket);
        super.setShortName("8");
    }
}
