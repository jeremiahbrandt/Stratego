package Server.Move;


import Protocol.SquarePacket;

public class NormalMoveValidator implements IMoveValidator {

    public NormalMoveValidator() {

    }

    @Override
    public boolean isValidMove(SquarePacket currentLocation, SquarePacket newLocation) {
        int currentRow = currentLocation.row;
        int currentColumn = currentLocation.col;

        int newRow = newLocation.row;
        int newColumn = newLocation.col;

        int rowDifference = Math.abs(currentRow - newRow);
        int columnDifference = Math.abs(currentColumn - newColumn);

        if(rowDifference == 1 && columnDifference == 0) {
            return true;
        }

        if(columnDifference == 1 && rowDifference == 0) {
            return true;
        }

        if(rowDifference == 1 && columnDifference == 1) {
            return true;
        }

        return false;
    }
}
