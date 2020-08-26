package Protocol.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Protocol.SquarePacket;
public class Lieutenant extends APiece {
    public Lieutenant(SquarePacket squarePacket) {
        super("Lieutenant", 5, new NormalMoveValidator(), squarePacket);
    }
}
