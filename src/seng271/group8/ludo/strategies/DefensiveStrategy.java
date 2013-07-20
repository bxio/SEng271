package seng271.group8.ludo.strategies;

import java.util.List;
import seng271.group8.ludo.model.Move;

/**
 *
 * @author bill
 */
public class DefensiveStrategy extends AbstractStrategy {
	//(3)Defensive: Give preference to a move to a target field where the pawn cannot be kicked;
	public DefensiveStrategy() {
            this.name = "Defensive";
        }

	public Move getMove(List<Move> moves) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
    
}
