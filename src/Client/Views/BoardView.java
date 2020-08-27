package Client.Views;

import Client.Client;
import Protocol.BoardPacket;
import Protocol.Request;
import Protocol.SquarePacket;
import Protocol.Piece.APiece;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

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
                SquareView squareView = new SquareView(this);
                squareView.setLayoutX(i * 75);
                squareView.setLayoutY(j * 75);
                squareViews.add(squareView);
                super.getChildren().add(squareView);
            }
        }
    }

    public void sendMove(SquareView selectedSquareView, SquareView destinationSquareView) {
        int previousLocationRow = (int) selectedSquareView.getLayoutX() / 75;
        int previousLocationCol = (int) selectedSquareView.getLayoutY() / 75;
        SquarePacket previousLocation = new SquarePacket(previousLocationCol, previousLocationRow);

        int newLocationRow = (int) destinationSquareView.getLayoutX() / 75;
        int newLocationCol = (int) destinationSquareView.getLayoutY() / 75;
        SquarePacket newLocation = new SquarePacket(newLocationCol, newLocationRow);

        client.sendRequest(new Request(previousLocation, newLocation));
    }

    public void displayBoard(BoardPacket boardPacket) {
        for(SquareView squareView: squareViews) {
            squareView.setText("");
        }

        this.boardPacket = boardPacket;
        for(APiece piece: boardPacket.getPieces()) {
            for(SquareView currentSquareView: squareViews) {
                int pieceRow = piece.getLocation().col;
                int pieceCol = piece.getLocation().row;
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
