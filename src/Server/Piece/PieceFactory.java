package Server.Piece;

import Server.Square;

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

    public APiece getNextPiece(Square square) {
        while(true) {
            int randomInteger = (int)(Math.random()*((numOfPieceLeft.size()-1)+1))+0;
            String pieceCode = pieceCodes[randomInteger];
            if(numOfPieceLeft.get(pieceCode) > 0) {
                this.numOfPieceLeft.replace(pieceCode, this.numOfPieceLeft.get(pieceCode)-1);
                switch (pieceCode) {
                    case "Bomb": return new Bomb(square);
                    case "Marshall": return new Marshall(square);
                    case "General": return new General(square);
                    case "Colonel": return new Colonel(square);
                    case "Major": return new Major(square);
                    case "Captain": return new Captain(square);
                    case "Lieutenant": return new Lieutenant(square);
                    case "Sergeant": return new Sergeant(square);
                    case "Miner": return new Miner(square);
                    case "Scout": return new Scout(square);
                    case "Spy": return new Spy(square);
                    case "Flag": return new Flag(square);
                    default: throw new Error();
                }
            }
        }
    }
}
