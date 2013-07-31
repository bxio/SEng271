package seng271.group8.ludo.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import seng271.group8.ludo.model.Move;

/** The Aggressive strategy gives preference to a move that kicks a pawn
 *
 * I'll be a large dbag and kick as many people as possible. 
 * 
 * @author bill
 */
public class AggressiveStrategy extends AbstractStrategy {
	
	public AggressiveStrategy(){
		this.name = "Aggressive";
	}

	public Move getMove(List<Move> moves) {
		System.out.println("#Moves:"+moves.size());
		List<Move> kickmoves = new ArrayList<Move>(), nonkickmoves = new ArrayList<Move>();
		Random rng = new Random();
		Move bestMove = null;

		//loop through the moves list, find the ones that result in other pawns being kicked.
		if(moves.isEmpty()){
			return null;
		}else if(moves.size() == 1){
			return moves.get(0);
		}else{
			for(int i=0;i<moves.size();i++){
				if(moves.get(i).doesKick()){
					kickmoves.add(moves.get(i));
				}else{
					nonkickmoves.add(moves.get(i));
				}
			}
			if(!kickmoves.isEmpty()){
				//there is a move that kicks a pawn. Randomly pick a victim
				bestMove = kickmoves.get(rng.nextInt(kickmoves.size()));
			}else{
				//there is no move that kicks another pawn.
				bestMove = nonkickmoves.get(rng.nextInt(nonkickmoves.size()));
			}
			return bestMove;
		}
	}
}
