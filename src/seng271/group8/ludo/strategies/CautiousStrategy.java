package seng271.group8.ludo.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import seng271.group8.ludo.model.Move;

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

	public Move getMove(List<Move> moves) {
		List<Move> nonkickmoves = new ArrayList<Move>(), kickmoves = new ArrayList<Move>();
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
			if(kickmoves.isEmpty()){
				//there are no moves that kick.
				bestMove = moves.get(rng.nextInt(nonkickmoves.size()));
			}else{
				bestMove = moves.get(rng.nextInt(kickmoves.size()));
			}
			return bestMove;
		}

	}
}
