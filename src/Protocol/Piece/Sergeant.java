package Protocol.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Protocol.SquarePacket;

public class Sergeant extends APiece {
    public Sergeant(SquarePacket squarePacket) {
        super("Sergeant", 4, new NormalMoveValidator(), squarePacket);
    }
}
