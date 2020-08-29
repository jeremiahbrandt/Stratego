package main.java.Protocol;

public class Request implements Packet {
    public final SquarePacket previousLocation;
    public final SquarePacket newLocation;

    public Request(SquarePacket previousLocation, SquarePacket newLocation) {
        this.previousLocation = previousLocation;
        this.newLocation = newLocation;
    }
}
