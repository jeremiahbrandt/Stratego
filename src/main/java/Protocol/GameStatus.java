package main.java.Protocol;

public class GameStatus implements Packet {
    private final String status;

    public GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
