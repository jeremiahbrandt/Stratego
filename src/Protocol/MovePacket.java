package Protocol;

import Server.Piece.APiece;

import java.util.Map;

public class MovePacket extends Request {
    private Map<APiece, SquarePacket> moves;

    public MovePacket(Map<APiece, SquarePacket> moves) {
        this.moves = moves;
    }
}
