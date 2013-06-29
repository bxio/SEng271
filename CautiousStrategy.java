/**
 *
 * @author bill
 */
public class CautiousStrategy implements Strategy{
	//(2)Cautious: Give low priority to a move that kicks a pawn (so as not to anger the other
	//player);
	private String name = "Cautious";
	
	@Override
	public int[] getMoves(Ludogame game, Player self, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public String getName(){
		return this.name;
	}
	
    
}
