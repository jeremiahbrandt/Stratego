package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class Major extends APiece {
    public Major(Square square) {
        super("Major", 7, new NormalMoveValidator(), square);
    }
}
