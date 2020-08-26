package Protocol.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Protocol.SquarePacket;

public class Spy extends APiece {
    public Spy(SquarePacket squarePacket) {
        super("Spy", 1, new NormalMoveValidator(), squarePacket);
    }
}
