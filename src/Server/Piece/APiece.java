package Server.Piece;

import Server.MoveHandlers.IMoveValidator;
import Protocol.SquarePacket;

import java.io.Serializable;

public abstract class APiece implements Serializable {
    private String name;
    private int rank;
    private IMoveValidator moveValidator;
    private SquarePacket squarePacket;
    private boolean jailed;

    public APiece(String name, int rank, IMoveValidator moveValidator, SquarePacket squarePacket) {
        super();
        this.name = name;
        this.rank = rank;
        this.moveValidator = moveValidator;
        this.squarePacket = squarePacket;
        this.jailed = false;
    }

    public SquarePacket getLocation() {
        return this.squarePacket;
    }

    public void setLocation(SquarePacket squarePacket) {
        this.squarePacket = squarePacket;
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
