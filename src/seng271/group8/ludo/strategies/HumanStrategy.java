package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class HumanStrategy extends AbstractStrategy {

        public HumanStrategy() {
            this.name = "Human Player";
        }
    
	public Pawn getMove(Player player, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
