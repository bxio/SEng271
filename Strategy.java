/**
 *
 * @author bill
 */
public interface Strategy {
	public int[] getMoves(Player player, int roll);//getMoves calculates all available moves
	public int rankMove();//rankmove takes the moves and returns the index of the move to make.
	public String getName();
}
