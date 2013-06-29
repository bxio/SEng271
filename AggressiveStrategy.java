/**
 *
 * @author bill
 */
public class AggressiveStrategy implements Strategy{
	//(1)Aggressive: Give preference to a move that kicks a pawn;
	private String name = "Aggressive";
	
	@Override
	public String getName(){
		return this.name;
	}

	@Override
	public Pawn getMove(Ludogame game, Player self, int roll) {
		Pawn moves[] = new Pawn[4];
		for(Pawn p:self.getPawns()){
			
		}
		
		return moves[0];
	}


}
