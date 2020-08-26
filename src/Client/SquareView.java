package Client;

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
    private static Border defaultBorder = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS));
    private static Color defaultBackground = Color.BLUE;
    private final BoardView boardView;

    private Rectangle bg;
    private Text text;

    public SquareView(BoardView boardView) {
        super();
        super.setOnMouseClicked(mouseEvent -> handleClick(mouseEvent));
        bg = new Rectangle(75, 75);
        bg.setFill(defaultBackground);
        super.setBorder(defaultBorder);
        text = new Text();
        text.setFont(Font.font("TimesRoman", FontWeight.LIGHT, 10));
        super.getChildren().addAll(bg, text);

        this.boardView = boardView;
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

    public void setText(String text) {
        this.text.setText(text);
    }
}
