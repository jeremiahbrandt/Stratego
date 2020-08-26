package Client;

import Protocol.BoardPacket;
import Protocol.MovePacket;
import Protocol.SquarePacket;
import Server.Piece.APiece;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class BoardView extends Group {
    private Client client;
    private BoardPacket boardPacket;
    private List<SquareView> squareViews;

    public BoardView(Client client) {
        super();
        this.client = client;
        squareViews = new ArrayList<>();

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                SquareView squareView = new SquareView();
                squareView.setLayoutX(i * 75);
                squareView.setLayoutY(j * 75);
                squareViews.add(squareView);
                super.getChildren().add(squareView);
            }
        }
    }

    public void displayMoves(MovePacket movePacket) {

    }

    public void displayBoard(BoardPacket boardPacket) {
        for(APiece piece: boardPacket.getPieces()) {
            for(SquareView currentSquareView: squareViews) {
                int pieceRow = piece.getLocation().row;
                int pieceCol = piece.getLocation().col;
                int currentRow = (int) currentSquareView.getLayoutX() / 75;
                int currentCol = (int) currentSquareView.getLayoutY() / 75;
                if(pieceRow == currentRow && pieceCol == currentCol) {
                    currentSquareView.setText(piece.toString());
                    break;
                }
            }
        }
    }
}
