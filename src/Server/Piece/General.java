package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class General extends APiece {
    public General(Square square) {
        super("General", 9, new NormalMoveValidator(), square);
    }
}
