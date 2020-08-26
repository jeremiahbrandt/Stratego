package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class Spy extends APiece {
    public Spy(Square square) {
        super("Spy", 1, new NormalMoveValidator(), square);
    }
}
