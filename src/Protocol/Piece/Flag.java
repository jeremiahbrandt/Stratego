package Protocol.Piece;

import Server.Move.StationaryMoveValidator;
import Protocol.SquarePacket;

public class Flag extends APiece {
    public Flag(SquarePacket squarePacket) {
        super("Flag", 0, new StationaryMoveValidator(), squarePacket);
    }
}
