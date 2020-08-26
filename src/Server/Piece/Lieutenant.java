package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;
public class Lieutenant extends APiece {
    public Lieutenant(Square square) {
        super("Lieutenant", 5, new NormalMoveValidator(), square);
    }
}
