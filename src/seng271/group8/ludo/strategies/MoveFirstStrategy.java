package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.PathSegment;
import seng271.group8.ludo.model.Pawn;

/** Give preference to moving the foremost pawn;
 *
 * @author bill
 */
public class MoveFirstStrategy extends AbstractStrategy {
	public MoveFirstStrategy() {
            this.name = "Move First";
        }

	public Move getMove(List<Move> moves) {
		if(moves.isEmpty()){
			return null;
		}else if(moves.size() == 1){
			return moves.get(0);
		}else{
			//iterate through the board and move my pawn that is furthest ahead
			Pawn pole = null;
			PathSegment path = moves.get(0).getPawn().getOwner().getPath().getFirst();
			while(path != null){
				
				if(path.getSquare().getPawn() != null && !path.getSquare().getPawn().isOnGoal()){
					pole = path.getSquare().getPawn();
				}
				path = path.getNext();
			}
			
			if(pole == null){
				return moves.get(0);
			}else{
				for(int i=0;i<moves.size();i++){
					if(moves.get(i).getPawn() == pole){
						return moves.get(i);
					}
				}
			}
			return moves.get(0);
		}
	}
}
