package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class Marshall extends APiece {
    public Marshall(Square square) {
        super("Marshall", 10, new NormalMoveValidator(), square);
    }
}
