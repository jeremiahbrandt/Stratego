package Client.Views;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ChatView extends VBox {
    private Text title;
    private TextArea messages;
    private TextField input;
    private Button sendButton;

    public ChatView() {
        title = new Text("Messages");
        TextArea textArea = new TextArea();

        TextArea messages = new TextArea();
        TextField input = new TextField();
        sendButton = new Button("Send");

        super.getChildren().addAll(title, messages, input, sendButton);
    }
}
