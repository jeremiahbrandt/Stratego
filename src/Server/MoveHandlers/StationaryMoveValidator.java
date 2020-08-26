package Server.MoveHandlers;

import Protocol.SquarePacket;

public class StationaryMoveValidator implements IMoveValidator {
    @Override
    public boolean isValidMove(SquarePacket currentLocation, SquarePacket newLocation) {
        return false;
    }
}