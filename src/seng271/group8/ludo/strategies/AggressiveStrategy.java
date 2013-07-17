package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class AggressiveStrategy extends AbstractStrategy {
	//(1)Aggressive: Give preference to a move that kicks a pawn;
	
        public AggressiveStrategy(){
            this.name = "Aggressive";
        }

	public Move getMove(Player player, int roll) {
            return null;//return new Move();
	}
}
