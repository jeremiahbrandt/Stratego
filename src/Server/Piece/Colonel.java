package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class Colonel extends APiece {
    public Colonel(Square square) {
        super("Colonel", 8, new NormalMoveValidator(), square);
    }
}
