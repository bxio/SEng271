package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class MoveLastStrategy extends AbstractStrategy {
	//(5)Move-last: Give preference to moving the hindmost pawn.
	public MoveLastStrategy() {
            this.name = "Move Last";
        }

	public Pawn getMove(Player player, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
