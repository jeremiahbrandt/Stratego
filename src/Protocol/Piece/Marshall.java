package Protocol.Piece;

import Server.Move.NormalMoveValidator;
import Protocol.SquarePacket;

public class Marshall extends APiece {
    public Marshall(SquarePacket squarePacket) {
        super("Marshall", 10, new NormalMoveValidator(), squarePacket);
    }
}
