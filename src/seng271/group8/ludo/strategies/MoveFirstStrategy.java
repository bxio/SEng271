package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;

/**
 *
 * @author bill
 */
public class MoveFirstStrategy extends AbstractStrategy {
	//(4)Move-first: Give preference to moving the foremost pawn;
	public MoveFirstStrategy() {
            this.name = "Move First";
        }

	public Move getMove(List<Move> moves) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
