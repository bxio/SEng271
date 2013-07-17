package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public interface Strategy {
	public Move getMove(Player player, int roll);//getMoves calculates all available moves
}
