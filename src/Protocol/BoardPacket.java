package Protocol;

import Protocol.Piece.APiece;

import java.util.ArrayList;
import java.util.List;

public class BoardPacket implements Packet {
    private List<APiece> pieces;

    public BoardPacket() {
        this.pieces = new ArrayList<>();
    }

    public void addPiece(APiece piece) {
        pieces.add(piece);
    }

    public void addArmy(List<APiece> army) {
        for(APiece piece: army) {
            pieces.add(piece);
        }
    }

    public List<APiece> getPieces() {
        return pieces;
    }
}
