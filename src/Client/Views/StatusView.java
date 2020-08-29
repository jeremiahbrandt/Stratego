package Client.Views;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class StatusView extends Text {
    private String text;

    public StatusView() {
        super();
        text = "";
        super.setTextAlignment(TextAlignment.CENTER);
        super.setText(text);
        super.setFont(new Font(40));
    }
}
