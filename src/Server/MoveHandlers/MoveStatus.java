package Server.MoveHandlers;

import java.io.Serializable;

public enum MoveStatus implements Serializable {
    INVALID,
    ATTACKER_UNOPPOSED,
    EQUAL_MATCH,
    DEFENDER_VICTORIOUS,
    ATTACKER_VICTORIOUS,
    FLAG_CAPTURE
}
