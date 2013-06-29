/**
 *
 * @author bill
 */
public class DefensiveStrategy implements Strategy{
	//(3)Defensive: Give preference to a move to a target field where the pawn cannot be kicked;
	private String name = "Defensive";
	
	@Override
	public Pawn getMove(Ludogame game, Player self, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public String getName(){
		return this.name;
	}
    
}
