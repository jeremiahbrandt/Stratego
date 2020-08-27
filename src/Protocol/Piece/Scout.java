package Protocol.Piece;

import Server.Move.ScoutMoveValidator;
import Protocol.SquarePacket;

public class Scout extends APiece {
    public Scout(SquarePacket squarePacket) {
        super("Scout", 2, new ScoutMoveValidator(), squarePacket);
    }
}
