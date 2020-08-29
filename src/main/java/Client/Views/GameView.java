package main.java.Client.Views;

import main.java.Client.Client;
import main.java.Protocol.BoardPacket;
import main.java.Protocol.GameStatus;
import main.java.Protocol.Message;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {
    private StatusView statusView;
    private BoardView boardView;
    private ChatView chatView;

    public GameView(Client client) {
        statusView = new StatusView();
        super.setTop(statusView);
        BorderPane.setAlignment(statusView, Pos.CENTER);

        chatView = new ChatView(client);
        super.setLeft(chatView);

        boardView = new BoardView(client);
        BorderPane.setAlignment(boardView, Pos.CENTER);
        super.setRight(boardView);
    }

    public void displayGameStatus(GameStatus gameStatus) {
        this.statusView.setText(gameStatus.getStatus());
    }

    public void displayBoard(BoardPacket boardPacket) {
        boardView.displayBoard(boardPacket);
    }

    public void displayMessage(Message message) {
        chatView.displayMessage(message);
    }

    public BoardView getBoardView() {
        return boardView;
    }
}
