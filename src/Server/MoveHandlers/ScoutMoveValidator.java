package Server.MoveHandlers;


import Server.Square;

public class ScoutMoveValidator implements IMoveValidator {
    public ScoutMoveValidator() {

    }

    @Override
    public boolean isValidMove(Square currentLocation, Square newLocation) {
        int currentRow = currentLocation.row;
        int currentColumn = currentLocation.col;

        int newRow = newLocation.row;
        int newColumn = newLocation.col;

        int rowDifference = Math.abs(currentRow - newRow);
        int columnDifference = Math.abs(currentColumn - newColumn);

        if(rowDifference > 0 && columnDifference == 0) {
            return true;
        }

        if(columnDifference > 0 && rowDifference == 0) {
            return true;
        }

        if(rowDifference == 1 && columnDifference == 1) {
            return true;
        }

        return false;
    }
}