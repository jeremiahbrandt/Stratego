package Protocol.Piece;

import Server.Move.NormalMoveValidator;
import Protocol.SquarePacket;

public class Major extends APiece {
    public Major(SquarePacket squarePacket) {
        super("Major", 7, new NormalMoveValidator(), squarePacket);
    }
}
