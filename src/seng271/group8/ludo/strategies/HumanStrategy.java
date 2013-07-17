package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class HumanStrategy extends AbstractStrategy {

        public HumanStrategy() {
            this.name = "Human Player";
        }
    
	public Move getMove(Player player, int roll) {
            // No move is returned. The move is selected through UI events
            // by the human player.
            return null;
        }
}
