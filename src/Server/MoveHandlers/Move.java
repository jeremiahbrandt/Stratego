package Server.MoveHandlers;

import Protocol.MovePacket;
import Server.Piece.APiece;
import Protocol.SquarePacket;

public class Move {
    private SquarePacket previousLocation;
    private SquarePacket newLocation;

    private APiece attacker;
    private APiece defender;

    private String message;
    private boolean isSuccessful;

    public MoveStatus status;

    public Move(MovePacket movePacket) {
//        this.game = game;
//        this.previousLocation = movePacket.previousLocation;
//        this.newLocation = movePacket.newLocation;
//        this.status = MoveStatus.INVALID;
//
//        try {
//            this.attacker = getPieceAtSquare(this.previousLocation);
//        } catch (PieceNotFoundException e) {
//            this.message = "Please select one of your pieces to move!";
//            return;
//        }
//
//        boolean isLegalDistance = checkMoveDistance();
//        if(!isLegalDistance) {
//            return;
//        }
//
//        try {
//            this.defender = getPieceAtSquare(this.newLocation);
//        } catch (PieceNotFoundException e) {
//            attacker.setLocation(newLocation);
//            this.status = MoveStatus.ATTACKER_UNOPPOSED;
//            return;
//        }
//
//        if(this.attacker != null && this.defender != null && isLegalDistance) {
//            this.commenceAttack();
//        }
//    }
//
//    private APiece getPieceAtSquare(SquareData location) throws PieceNotFoundException {
//        for(Player player: game.players) {
//            for(APiece piece: player.getArmy()) {
//                if(piece.getLocation().row == location.row && piece.getLocation().col == location.col && !piece.getIsJailed()) {
//                    return piece;
//                }
//            }
//        }
//        throw new PieceNotFoundException("Unable to get piece at " + location);
//    }
//
//
//    private boolean checkMoveDistance() {
//        if(attacker.getMoveHandler().isValidMove(previousLocation, newLocation)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private void commenceAttack() {
//        this.isSuccessful = true;
//        if(checkForFlag()) {
//            attacker.setLocation(newLocation);
//            defender.sendToJail();
//            this.status = MoveStatus.FLAG_CAPTURE;
//        } else if(attacker.getRank() > defender.getRank() || bombIsDisfused() || checkForSpy()) {
//            attacker.setLocation(newLocation);
//            defender.sendToJail();
//            this.status = MoveStatus.ATTACKER_VICTORIOUS;
//        } else if (attacker.getRank() < defender.getRank()) {
//            attacker.sendToJail();
//            this.status = MoveStatus.DEFENDER_VICTORIOUS;
//        } else {
//            this.status = MoveStatus.EQUAL_MATCH;
//        }
//    }
//
//    private boolean checkForFlag() {
//        return defender instanceof Flag;
//    }
//
//    private boolean bombIsDisfused() {
//        boolean attackerIsMiner = attacker instanceof Miner;
//        boolean defenderIsBomb = defender instanceof Bomb;
//
//        return attackerIsMiner && defenderIsBomb;
//    }
//
//    private boolean checkForSpy() {
//        boolean attackerIsScout = attacker instanceof Spy;
//        boolean defenderIsMarshall = defender instanceof Marshall;
//
//        return attackerIsScout && defenderIsMarshall;
//    }
//
//    public String getMessage() {
//        switch (status) {
//            case ATTACKER_UNOPPOSED: return attacker + " moved to " + newLocation + ".";
//            case EQUAL_MATCH: return attacker + " and " + defender + " were unable to defeat each other!";
//            case DEFENDER_VICTORIOUS: return defender + " defended against " + attacker + ".";
//            case ATTACKER_VICTORIOUS: return attacker + " defeated " + defender + ".";
//            case FLAG_CAPTURE: return attacker + " captured the flag!";
//            default: return "Invalid move!";
//        }
    }
}