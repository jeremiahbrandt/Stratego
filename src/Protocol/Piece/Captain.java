package Protocol.Piece;

import Server.Move.NormalMoveValidator;
import Protocol.SquarePacket;

public class Captain extends APiece {
    public Captain(SquarePacket squarePacket) {
        super("Captain", 6, new NormalMoveValidator(), squarePacket);
        super.setShortName("6");
    }
}
