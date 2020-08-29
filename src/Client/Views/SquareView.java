package Client.Views;

import Protocol.Piece.APiece;
import Protocol.Piece.Enemy;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
    private APiece occupant;

    private Shape bg;
    private Text text;

    public SquareView(BoardView boardView) {
        this.boardView = boardView;

        super.setOnMouseClicked(this::handleClick);
        super.setBorder(defaultBorder);

        text = new Text();
        text.setFill(defaultColor);
        text.setFont(Font.font("TimesRoman", FontWeight.LIGHT, 20));

        bg = new Circle(35);
        super.getChildren().addAll(bg, text);
    }

    public void removeOccupant() {
        bg.setVisible(false);
        text.setText("");
        this.occupant = null;
        setBackgroundColor();
    }

    public void setOccupant(APiece newOccupant) {
        bg.setVisible(true);
        occupant = newOccupant;
        setBackgroundColor();

        if(occupant != null) {
            text.setText(occupant.getShortName());
        }
    }

    private void setBackgroundColor() {
        if(occupant == null) {
            bg.setFill(defaultColor);
        } else if (occupant instanceof Enemy) {
            bg.setFill(enemyColor);
        } else {
            bg.setFill(friendlyColor);
        }
    }

    private void handleClick(MouseEvent e) {
        if(e.getButton() == MouseButton.PRIMARY) {
            if(occupant != null && !(occupant instanceof Enemy)) {
                selectedSquareView = this;
            }
        } else if (e.getButton() == MouseButton.SECONDARY) {
            if(occupant == null || occupant instanceof Enemy) {
                destinationSquareView = this;
                boardView.sendMove(selectedSquareView, destinationSquareView);
                selectedSquareView = null;
                destinationSquareView = null;
            }
        }
    }
}
