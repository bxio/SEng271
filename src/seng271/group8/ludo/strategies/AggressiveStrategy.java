package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;

/**
 *
 * @author bill
 */
public class AggressiveStrategy extends AbstractStrategy {
	//(1)Aggressive: Give preference to a move that kicks a pawn;
	
        public AggressiveStrategy(){
            this.name = "Aggressive";
        }

	public Move getMove(List<Move> moves) {
            Move bestMove = null;
            if(!moves.isEmpty())
                bestMove =  moves.get(0);
            return bestMove;
	}
}
