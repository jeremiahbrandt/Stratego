package Protocol.Piece;

import Protocol.SquarePacket;
import Server.MoveHandlers.StationaryMoveValidator;

public class Enemy extends APiece {
    public Enemy(SquarePacket squarePacket) {
        super("Enemy", -1, new StationaryMoveValidator(), squarePacket);
    }
}
