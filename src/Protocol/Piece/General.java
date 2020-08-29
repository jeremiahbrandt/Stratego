package Protocol.Piece;

import Server.Move.NormalMoveValidator;
import Protocol.SquarePacket;

public class General extends APiece {
    public General(SquarePacket squarePacket) {
        super("General", 9, new NormalMoveValidator(), squarePacket);
        super.setShortName("9");
    }
}
