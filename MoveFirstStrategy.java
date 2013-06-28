/**
 *
 * @author bill
 */
public class MoveFirstStrategy implements Strategy{
	//(4)Move-first: Give preference to moving the foremost pawn;
	private String name = "Move First";
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
