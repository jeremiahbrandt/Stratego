package Client.Views;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SquareView extends StackPane {
    private static SquareView selectedSquareView;
    private static SquareView destinationSquareView;
    private static Color defaultColor = Color.rgb(225, 238, 238);
    private static Color activeColor = Color.rgb(56, 127, 242);
    private static Color friendlyColor = Color.rgb(25,55, 210);
    private static Color enemyColor = Color.rgb(153, 0, 0);
    private static Color textColor = Color.rgb(210, 240, 240);
    private static Border defaultBorder = new Border(new BorderStroke(Color.rgb(95, 95, 95), BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS));
    private final BoardView boardView;

    private Rectangle bg;
    private Text text;

    public SquareView(BoardView boardView) {
        super();
        super.setOnMouseClicked(mouseEvent -> handleClick(mouseEvent));
        super.setBorder(defaultBorder);

        text = new Text();
        text.setFont(Font.font("TimesRoman", FontWeight.LIGHT, 10));
        bg = new Rectangle(75, 75);

        super.getChildren().addAll(bg, text);

        this.boardView = boardView;
    }

    public void setText(String text) {
        this.text.setText(text);
        setBackgroundColor();
    }

    private void handleClick(MouseEvent e) {
        if(e.getButton() == MouseButton.PRIMARY) {
            if(text.getText() != "" && !text.getText().contains("-1")) {
                selectedSquareView = this;
            }
        } else if (e.getButton() == MouseButton.SECONDARY) {
            if(text.getText() == "" || text.getText().contains("-1")) {
                destinationSquareView = this;
                boardView.sendMove(selectedSquareView, destinationSquareView);
                selectedSquareView = null;
                destinationSquareView = null;
            }
        }
    }

    private void setBackgroundColor() {
        if(text.getText() == "") {
            bg.setFill(defaultColor);
        } else if (text.getText().contains("-1")) {
            bg.setFill(enemyColor);
        } else {
            bg.setFill(friendlyColor);
        }
    }
}
