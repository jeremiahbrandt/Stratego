package Server.MoveHandlers;

import Server.Square;

public class StationaryMoveValidator implements IMoveValidator {
    @Override
    public boolean isValidMove(Square currentLocation, Square newLocation) {
        return false;
    }
}