package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.Square;

/** Give preference to a move to a target field where the pawn cannot be kicked.
 * This strategy picks the move that moves the player's pawns as far away from 
 * other player's pawns as possible.
 * 
 * In other words, I am a coward and I make my pawns 
 * run as far away from others as possible.
 * 
 * @author bill
 */
public class DefensiveStrategy extends AbstractStrategy {
	public DefensiveStrategy() {
            this.name = "Defensive";
        }

	public Move getMove(List<Move> moves) {
		//iterate through the board
		
		//choose the move that moves me furthest away from everyone else.
		
		
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
    
}
