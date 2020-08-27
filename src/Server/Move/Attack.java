package Server.Move;

import Protocol.Piece.*;

public class Attack {
    private APiece attacker;
    private APiece defender;
    private APiece winner;

    public Attack(APiece attacker, APiece defender) {
        this.attacker = attacker;
        this.defender = defender;

        commenceAttack();
    }

    public APiece getWinner() {
        return winner;
    }

    private void commenceAttack() {
        if(spyDefeatsMarshall() || minerDefusesBomb()) {
            winner = attacker;
            return;
        }

        if(attacker.getRank() > defender.getRank()) {
            winner = attacker;
        } else if(defender.getRank() > attacker.getRank()) {
            winner = defender;
        }
    }

    private boolean spyDefeatsMarshall() {
        return attacker instanceof Spy && defender instanceof Marshall;
    }

    private boolean minerDefusesBomb() {
        return attacker instanceof Miner && defender instanceof Bomb;
    }
}