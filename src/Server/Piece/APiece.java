package Server.Piece;

import Server.MoveHandlers.IMoveValidator;
import Server.Square;

public abstract class APiece {
    private String name;
    private int rank;
    private IMoveValidator moveValidator;
    private Square square;
    private boolean jailed;

    public APiece(String name, int rank, IMoveValidator moveValidator, Square square) {
        super();
        this.name = name;
        this.rank = rank;
        this.moveValidator = moveValidator;
        this.square = square;
        this.jailed = false;
    }

    public Square getLocation() {
        return this.square;
    }

    public void setLocation(Square square) {
        this.square = square;
    }

    public IMoveValidator getMoveValidator() {
        return this.moveValidator;
    }

    public int getRank() {
        return this.rank;
    }

    public void sendToJail() {
        this.jailed = true;
    }

    public boolean getIsJailed() {
        return this.jailed;
    }

    public String toString() {
        return this.name + " (" + this.rank + ")";
    }
}
