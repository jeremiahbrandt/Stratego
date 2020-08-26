package Protocol;

public class BoardPacket implements Packet {
    public String[][] squares;

    public BoardPacket(String[][] squares) {
        this.squares = squares;
    }

    public void displayBoard() {

    }
}
