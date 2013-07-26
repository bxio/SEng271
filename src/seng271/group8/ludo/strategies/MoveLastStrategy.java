package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;

/** Give preference to moving the hindmost pawn.
 *
 * @author bill
 */
public class MoveLastStrategy extends AbstractStrategy {
	public MoveLastStrategy() {
            this.name = "Move Last";
        }

	public Move getMove(List<Move> moves) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
