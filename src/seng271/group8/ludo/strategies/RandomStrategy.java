package seng271.group8.ludo.strategies;

import java.util.List;
import java.util.Random;
import seng271.group8.ludo.model.Move;

/** A derpy strategy that returns a random move, always.
 *
 * @author bill
 */
public class RandomStrategy extends AbstractStrategy{
	private Random generator;

	public RandomStrategy() {
		this.name = "Random/Ditzy";
		generator = new Random();
	}
		
	@Override
	public Move getMove(List<Move> moves) {
		
		if(moves.isEmpty()){
			return null;
		}else if(moves.size() == 1){
			return moves.get(0);
		}else{
			if(moves.get(0).getRoll() != 6 || moves.get(0).getPawn().getOwner().getPath().getFirst().getSquare().getPawn() != null){
				//if roll isn't 6 and starting position is not empty
				return(moves.get(generator.nextInt(moves.size())));
			}else{
				//you rolled a 6 and starting position is empty.

			}
		}
		return(moves.get(generator.nextInt(moves.size())));
	}

}
