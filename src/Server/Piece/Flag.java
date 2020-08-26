package Server.Piece;

import Server.MoveHandlers.StationaryMoveValidator;
import Server.Square;

public class Flag extends APiece {
    public Flag(Square square) {
        super("Flag", 0, new StationaryMoveValidator(), square);
    }
}
