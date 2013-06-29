/**
 *
 * @author bill
 */
public class AggressiveStrategy implements Strategy{
	//(1)Aggressive: Give preference to a move that kicks a pawn;
	private String name = "Aggressive";
	public String getName(){
		return this.name;
	}

	@Override
	public int[] getMoves(Ludogame game, Player self, int roll) {
		int moves[] = new int[4];
		for(Pawn p:self.getPawns()){
			
		}
		return moves;
	}

	@Override
	public int rankMove() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
