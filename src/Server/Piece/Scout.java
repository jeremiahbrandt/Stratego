package Server.Piece;

import Server.MoveHandlers.ScoutMoveValidator;
import Server.Square;

public class Scout extends APiece {
    public Scout(Square square) {
        super("Scout", 2, new ScoutMoveValidator(), square);
    }
}
