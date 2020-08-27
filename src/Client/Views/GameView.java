package Client.Views;

import Client.Client;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {
    private BoardView boardView;
    private ChatView chatView;

    public GameView(Client client) {
        chatView = new ChatView();
        super.setLeft(chatView);

        boardView = new BoardView(client);
        super.setRight(boardView);
    }

    public BoardView getBoardView() {
        return boardView;
    }
}
