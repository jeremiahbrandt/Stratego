package main.java.Server.Move;


import main.java.Protocol.SquarePacket;

import java.io.Serializable;

public interface IMoveValidator extends Serializable {
    boolean isValidMove(SquarePacket currentLocation, SquarePacket newLocation);
}

