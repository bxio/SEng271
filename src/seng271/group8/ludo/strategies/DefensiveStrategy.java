package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;

/** Give preference to a move to a target field where the pawn cannot be kicked.
 * This strategy picks the move that moves the player's pawns as far away from 
 * other player's pawns as possible.
 *
 * @author bill
 */
public class DefensiveStrategy extends AbstractStrategy {
	public DefensiveStrategy() {
            this.name = "Defensive";
        }

	public Move getMove(List<Move> moves) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
    
}
