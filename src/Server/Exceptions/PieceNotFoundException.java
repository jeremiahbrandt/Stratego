package Server.Exceptions;

public class PieceNotFoundException extends Exception {
    private String message;

    public PieceNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
