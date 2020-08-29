package main.java.Protocol.Piece;

import main.java.Server.Move.IMoveValidator;
import main.java.Protocol.SquarePacket;

import java.io.Serializable;

public abstract class APiece implements Serializable {
    private String name;
    private String shortName;
    private int rank;
    private IMoveValidator moveValidator;
    private SquarePacket squarePacket;
    private boolean captured;

    public APiece(String name, int rank, IMoveValidator moveValidator, SquarePacket squarePacket) {
        super();
        this.name = name;
        this.rank = rank;
        this.moveValidator = moveValidator;
        this.squarePacket = squarePacket;
        this.captured = false;
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

    public String getName() {
        return this.name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void capture() {
        this.captured = true;
    }

    public boolean getIsCaptured() {
        return this.captured;
    }

    public String toString() {
        return this.name + " (" + this.rank + ")";
    }
}
