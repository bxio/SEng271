/**
 *
 * @author bill
 */
public class Ludogame {
	
    public static void main(String[] args) {
		//initiate the game
		Player players[] = new Player[4];
        players[0] = new Player();
        players[1] = new Player();
        players[2] = new Player();
        players[3] = new Player();
		//initiate the dice
        Dice dice = new Dice();
		Player winner = null;
		//initiate the players
        players[0].initPlayer("Blue",1,1);
        players[1].initPlayer("Yellow",2,11);
        players[2].initPlayer("Green",3,21);
        players[3].initPlayer("Red",4,31);
		//take a turn

		//tests

		players[1].getPawn(0).start();
		System.out.println("Pawn at Pos "+players[1].getPawn(0).getPosition());
		players[1].getPawn(0).move(40);
		System.out.println("Pawn now at Pos "+players[1].getPawn(0).getPosition());
    }

}