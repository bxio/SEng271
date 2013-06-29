/**
 *
 * @author bill
 */
public class MoveFirstStrategy implements Strategy{
	//(4)Move-first: Give preference to moving the foremost pawn;
	private String name = "Move First";
	
	@Override
	public int[] getMoves(Ludogame game, Player self, int roll) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public String getName(){
		return this.name;
	}

}
