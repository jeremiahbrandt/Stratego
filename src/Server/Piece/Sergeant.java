package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class Sergeant extends APiece {
    public Sergeant(Square square) {
        super("Sergeant", 4, new NormalMoveValidator(), square);
    }
}
