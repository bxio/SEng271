package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;

/** Give preference to moving the foremost pawn;
 *
 * @author bill
 */
public class MoveFirstStrategy extends AbstractStrategy {
	public MoveFirstStrategy() {
            this.name = "Move First";
        }

	public Move getMove(List<Move> moves) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
