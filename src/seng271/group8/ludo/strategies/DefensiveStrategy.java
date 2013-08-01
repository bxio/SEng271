package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.PathSegment;

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
		if(moves.isEmpty()){
			return null;
		}else if(moves.size() == 1){
			return moves.get(0);
		}else{
			//get the path

			//for each move, get the pawn, then get 11 spaces around the pawn (5 behind, 6 ahead)
			
			//check these spaces for enemies
			
			//Add move according to its rank.
			
			
			
			
			
			
			
			
			
			return null;
		}
	}
}
