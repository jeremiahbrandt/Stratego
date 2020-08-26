package Server;

public class Square {
    private static int rowCount = 0, colCount = 0;
    public int row, col;

    public Square() {
        row = rowCount;
        col = colCount;

        if(colCount == 9) {
            colCount = 0;
            rowCount++;
        } else {
            colCount++;
        }
    }
}
