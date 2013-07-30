package seng271.group8.ludo.strategies;

import java.util.ArrayList;
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
			List<Pawn> placement = new ArrayList<Pawn>();
			
			PathSegment path = moves.get(0).getPawn().getOwner().getPath().getFirst();
			while(path != null){
				//if pawn is not null and not in goal, add to list
				if(path.getSquare().getPawn() != null && !path.getSquare().getPawn().isOnGoal()){
					placement.add(path.getSquare().getPawn());
				}
				path = path.getNext();
			}
			
			//check if home is empty. If it is, and roll is 6, prioritize pawns leaving home.			
			if(moves.get(0).getRoll() != 6 || moves.get(0).getPawn().getOwner().getPath().getFirst().getSquare().getPawn() != null){
				//I didn't roll 6 or my home is full.
				for(int i=0;i<moves.size();i++){
					if(placement.get(placement.size()-1) == moves.get(i).getPawn()){
						return moves.get(i);
					}
				}
			}else{
				//I rolled a 6 and my home is empty
				//return the first move that moves a pawn NOT on the list
				System.out.println("6 was rolled and home empty.");
				for(int i=0;i<moves.size();i++){
					if(!placement.contains(moves.get(i).getPawn())){
						return moves.get(i);
					}
				}
			}
			return moves.get(0);
		}
	}
}
