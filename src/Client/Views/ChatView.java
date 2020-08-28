package Client.Views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ChatView extends VBox {
    private static Font titleFont = new Font(25);
    private static Font secondaryFont = new Font(20);

    private Text title;
    private TextArea messages;

    private HBox inputContainer;
    private TextField input;
    private Button sendButton;


    public ChatView() {
        super.setAlignment(Pos.CENTER);
        super.setPrefWidth(450);
        title = new Text( "Messages");
        title.setFont(titleFont);
        messages = new TextArea();
        messages.setEditable(false);
        messages.setPrefHeight(685);

        inputContainer = new HBox();
        inputContainer.setPrefHeight(50);
        input = new TextField();
        input.setFont(secondaryFont);
        input.setPrefWidth(350);
        sendButton = new Button("Send");
        sendButton.setPrefWidth(100);
        sendButton.setFont(secondaryFont);
        inputContainer.getChildren().addAll(input, sendButton);

        super.getChildren().addAll(title, messages, inputContainer);
    }
}
