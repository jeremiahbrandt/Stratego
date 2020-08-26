package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class Captain extends APiece {
    public Captain(Square square) {
        super("Captain", 6, new NormalMoveValidator(), square);
    }
}
