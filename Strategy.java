/**
 *
 * @author bill
 */
public interface Strategy {
	public int[] getMoves(Ludogame game, Player self, int roll);//getMoves calculates all available moves
	public String getName();
}