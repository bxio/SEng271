package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class CautiousStrategy extends AbstractStrategy {
	//(2)Cautious: Give low priority to a move that kicks a pawn (so as not to anger the other
	//player);
	public CautiousStrategy() {
            this.name = "Cautious";
        }

	public Pawn getMove(Player player, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
