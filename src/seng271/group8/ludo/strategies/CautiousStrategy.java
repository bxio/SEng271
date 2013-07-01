package seng271.group8.ludo.strategies;

import seng271.group8.ludo.model.Player;

/**
 *
 * @author bill
 */
public class CautiousStrategy implements Strategy{
	//(2)Cautious: Give low priority to a move that kicks a pawn (so as not to anger the other
	//player);
	private String name = "Cautious";
	public String getName(){
		return this.name;
	}
	@Override
	public int[] getMoves(Player player, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int rankMove() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
    
}
