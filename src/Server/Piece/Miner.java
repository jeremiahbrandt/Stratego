package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Server.Square;

public class Miner extends APiece {
    public Miner(Square square) {
        super("Miner", 3, new NormalMoveValidator(), square);
    }
}
