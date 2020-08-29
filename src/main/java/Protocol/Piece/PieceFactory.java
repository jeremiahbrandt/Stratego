package main.java.Protocol.Piece;

import main.java.Protocol.SquarePacket;

import java.util.LinkedHashMap;
import java.util.Map;

public class PieceFactory {
    private Map<String, Integer> numOfPieceLeft;
    private String[] pieceCodes;

    public PieceFactory() {
        this.numOfPieceLeft = new LinkedHashMap<>();

        this.numOfPieceLeft.put("Bomb", 6);
        this.numOfPieceLeft.put("Marshall", 1);
        this.numOfPieceLeft.put("General", 1);
        this.numOfPieceLeft.put("Colonel", 2);
        this.numOfPieceLeft.put("Major", 3);
        this.numOfPieceLeft.put("Captain", 4);
        this.numOfPieceLeft.put("Lieutenant", 4);
        this.numOfPieceLeft.put("Sergeant", 4);
        this.numOfPieceLeft.put("Miner", 5);
        this.numOfPieceLeft.put("Scout", 8);
        this.numOfPieceLeft.put("Spy", 1);
        this.numOfPieceLeft.put("Flag", 1);


        this.pieceCodes = new String[12];
        int i=0;
        for(Map.Entry<String, Integer> piece: numOfPieceLeft.entrySet()) {
            pieceCodes[i] = piece.getKey();
            i++;
        }
    }

    public APiece getNextPiece(SquarePacket squarePacket) {
        while(true) {
            int randomInteger = (int) (Math.random() * ((numOfPieceLeft.size() - 1) + 1));
            String pieceCode = pieceCodes[randomInteger];
            if(numOfPieceLeft.get(pieceCode) > 0) {
                this.numOfPieceLeft.replace(pieceCode, this.numOfPieceLeft.get(pieceCode)-1);
                return switch (pieceCode) {
                    case "Bomb" -> new Bomb(squarePacket);
                    case "Marshall" -> new Marshall(squarePacket);
                    case "General" -> new General(squarePacket);
                    case "Colonel" -> new Colonel(squarePacket);
                    case "Major" -> new Major(squarePacket);
                    case "Captain" -> new Captain(squarePacket);
                    case "Lieutenant" -> new Lieutenant(squarePacket);
                    case "Sergeant" -> new Sergeant(squarePacket);
                    case "Miner" -> new Miner(squarePacket);
                    case "Scout" -> new Scout(squarePacket);
                    case "Spy" -> new Spy(squarePacket);
                    case "Flag" -> new Flag(squarePacket);
                    default -> throw new Error();
                };
            }
        }
    }
}
