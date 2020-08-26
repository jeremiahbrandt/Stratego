package Server.MoveHandlers;


import Server.Square;

public interface IMoveValidator {
    boolean isValidMove(Square currentLocation, Square newLocation);
}

