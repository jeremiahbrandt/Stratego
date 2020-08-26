package Protocol;

import java.io.Serializable;

public class SquarePacket implements Serializable {
    private static int rowCount = 0, colCount = 0;
    public int row, col;

    public SquarePacket() {
        row = rowCount;
        col = colCount;

        if(colCount == 9) {
            colCount = 0;
            rowCount++;
        } else {
            colCount++;
        }
    }

    public SquarePacket(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
