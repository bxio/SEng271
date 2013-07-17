package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class AggressiveStrategy implements Strategy{
	//(1)Aggressive: Give preference to a move that kicks a pawn;
	private String name = "Aggressive";

	public Pawn getMove(Player player, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public String getName(){
		return this.name;
	}
}
