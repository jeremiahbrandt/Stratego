package Server.Piece;

import Server.MoveHandlers.StationaryMoveValidator;
import Server.Square;

public class Bomb extends APiece {
    public Bomb(Square square) {
        super("Bomb", 12, new StationaryMoveValidator(), square);
    }
}
