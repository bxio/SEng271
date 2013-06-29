/**
 *
 * @author bill
 */
public interface Strategy {
	public Pawn getMove(Ludogame game, Player self, int roll);//getMoves calculates all available moves
	public String getName();
}