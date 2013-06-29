/**
 *
 * @author bill
 */
public class Ludogame {
	private Player players[];
    public static void main(String[] args) {
		//initiate the game
		Ludogame game = new Ludogame();
		game.players = new Player[4];
        game.players[0] = new Player();
        game.players[1] = new Player();
        game.players[2] = new Player();
        game.players[3] = new Player();
		//initiate the dice
        Dice dice = new Dice();
		Player winner = null;
		//initiate the players
        game.players[0].initPlayer("Blue",1,1);
        game.players[1].initPlayer("Yellow",2,11);
        game.players[2].initPlayer("Green",3,21);
        game.players[3].initPlayer("Red",4,31);
		//take a turn

		//tests
		game.players[1].getPawn(0).start();
		System.out.println("Pawn at Pos "+game.players[1].getPawn(0).getPosition());
		game.players[1].getPawn(0).move(null,40);
		System.out.println("Pawn now at Pos "+game.players[1].getPawn(0).getPosition());
    }
	public int[] getCurrentPositions(Player players[]){
		int i=0;
		int result[] = new int[16];
		for(Player p:players){
			for(Pawn r:p.getPawns()){
				result[i] = r.getPosition();
				++i;
			}
		}
		return result;
	}

}