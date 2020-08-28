package Protocol;

public class Message implements Packet {
    private final String sender;
    private final String msg;

    public Message(String sender, String msg) {
        this.sender = sender;
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public String getMsg() {
        return msg;
    }
}
