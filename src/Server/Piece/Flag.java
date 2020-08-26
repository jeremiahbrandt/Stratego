package Server.Piece;

import Server.MoveHandlers.StationaryMoveValidator;
import Protocol.SquarePacket;

public class Flag extends APiece {
    public Flag(SquarePacket squarePacket) {
        super("Flag", 0, new StationaryMoveValidator(), squarePacket);
    }
}
