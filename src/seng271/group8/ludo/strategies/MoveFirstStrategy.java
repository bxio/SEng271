package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class MoveFirstStrategy extends AbstractStrategy {
	//(4)Move-first: Give preference to moving the foremost pawn;
	public MoveFirstStrategy() {
            this.name = "Move First";
        }

	public Pawn getMove(Player player, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
