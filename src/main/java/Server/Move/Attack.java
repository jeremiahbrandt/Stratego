package main.java.Server.Move;

import main.java.Protocol.Piece.*;

public class Attack {
    private APiece attacker;
    private APiece defender;

    private APiece winner;
    private APiece loser;

    private String winnerMessage;
    private String loserMessage;

    public Attack(APiece attacker, APiece defender) {
        this.attacker = attacker;
        this.defender = defender;

        commenceAttack();
        setGameMessages();
    }

    public APiece getWinner() {
        return winner;
    }

    public String getWinnerMessage() {
        return winnerMessage;
    }

    public String getLoserMessage() {
        return loserMessage;
    }

    private void commenceAttack() {
        if(spyDefeatsMarshall() || minerDefusesBomb()) {
            winner = attacker;
            loser = defender;
            return;
        }

        if(attacker.getRank() > defender.getRank()) {
            winner = attacker;
            loser = defender;
        } else if(defender.getRank() > attacker.getRank()) {
            winner = defender;
            loser = attacker;
        }
    }

    private boolean spyDefeatsMarshall() {
        return attacker instanceof Spy && defender instanceof Marshall;
    }

    private boolean minerDefusesBomb() {
        return attacker instanceof Miner && defender instanceof Bomb;
    }

    private void setGameMessages() {
        if(loser instanceof Flag) {
            winnerMessage = "You captured your opponent's " + loser.getName() + "!";
            loserMessage = "Your " + loser.getName() +  " was captured!";
            return;
        }

        if (winner instanceof Bomb) {
            winnerMessage = "Your " + defender.getName() + " blew up your opponent's " + attacker.getName() + "!";
            loserMessage = "Your " + attacker.getName() + " was blown up by your opponent's " + defender.getName() + "!";
            return;
        }

        if(winner instanceof Miner && defender instanceof Bomb) {
            winnerMessage =  "Your " + attacker.getName() + " diffused your opponent's " + defender.getName() + "!";
            loserMessage = "Your " + defender.getName() + " was diffused by your opponent's " + attacker.getName() + "!";
            return;
        }

        if(winner instanceof Spy) {
            winnerMessage = "Your " + attacker.getName() + " sneakily took out your opponent's " + defender.getName() + "!";
            loserMessage = "Your " + defender.getName() + " was sneakily taken out by your opponent's " + attacker.getName() + "!";
            return;
        }

        winnerMessage = "Your " + winner.getName() + " defeated your opponent's " + loser.getName() + "!";
        loserMessage = "Your " + loser.getName() + " was defeated by your opponent's " + winner.getName() + "!";
    }
}