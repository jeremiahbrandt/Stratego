package Client.Views;

import Client.Client;
import Protocol.BoardPacket;
import Protocol.Message;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {
    private BoardView boardView;
    private ChatView chatView;

    public GameView(Client client) {
        chatView = new ChatView(client);
        super.setLeft(chatView);

        boardView = new BoardView(client);
        super.setRight(boardView);
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
