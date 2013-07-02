package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public interface Strategy {
	public Pawn getMoves(Player player, int roll);//getMoves calculates all available moves
	public String getName();
}
