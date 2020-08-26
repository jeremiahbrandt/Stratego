package Protocol.Piece;

import Server.MoveHandlers.StationaryMoveValidator;
import Protocol.SquarePacket;

public class Bomb extends APiece {
    public Bomb(SquarePacket squarePacket) {
        super("Bomb", 12, new StationaryMoveValidator(), squarePacket);
    }
}
