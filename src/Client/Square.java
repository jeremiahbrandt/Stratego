package Client;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Square extends StackPane {
    private static Border defaultBorder = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS));
    private static Color defaultBackground = Color.BLUE;

    private Rectangle bg;
    private Text text;

    public Square() {
        super();
        bg = new Rectangle(75, 75);
        bg.setFill(defaultBackground);
        super.setBorder(defaultBorder);
        text = new Text();
        text.setFont(Font.font("TimesRoman", FontWeight.LIGHT, 10));
        super.getChildren().addAll(bg, text);
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}
