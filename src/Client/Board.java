package Client;

import Protocol.BoardPacket;
import javafx.scene.Group;

public class Board extends Group {
    private Client client;
    private Square[][] squares;

    public Board(Client client) {
        super();
        this.client = client;

        squares = new Square[10][10];
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                Square square = new Square();
                squares[i][j] = square;
                square.setLayoutX(i * 75);
                square.setLayoutY(j * 75);
                super.getChildren().add(square);
            }
        }
    }

    public void displayBoard(BoardPacket boardPacket) {
        for(int i=0; i<boardPacket.squares.length; i++) {
            for(int j=0; j<boardPacket.squares.length; j++) {
                squares[i][j].setText(boardPacket.squares[i][j]);
            }
        }
    }
}
