/**
 *
 * @author bill
 */
import java.util.Scanner;
public class Ludogame {
	private Player players[];
    public static void main(String[] args) {
		int humanplayers = 0;
		System.out.println("Welcome to Ludogame.");
		/*
		System.out.print("Enter Number of human players:");
		Scanner in = new Scanner(System.in);
		humanplayers = in.nextInt();
		*/
		//initiate the game
		Ludogame game = new Ludogame();
		game.players = new Player[4];
        game.players[0] = new Player();
        game.players[1] = new Player();
        game.players[2] = new Player();
        game.players[3] = new Player();
		//initiate the players
		game.players[0].initPlayer("Blue",1,1);
        game.players[1].initPlayer("Yellow",2,11);
        game.players[2].initPlayer("Green",3,21);
        game.players[3].initPlayer("Red",4,31);
		for(int i=0;i<humanplayers;i++){
			game.players[i].setStrategy(0);
		}
		//initiate the dice
        Dice dice = new Dice();
		Player winner = null;
		
		game.players[2].getPawns()[3].setPosition(5);
		game.players[1].getPawns()[0].setPosition(2);
		
		System.out.println(game.printCurrentPositions());

		game.players[1].getPawns()[0].move(game, 3);
		System.out.println(game.printCurrentPositions());
		
    }
	/** Returns a single player at a given index
	 * 
	 * @param index the index of the player in the player array(0-3)
	 * @return the player at that index
	 */
	public Player getPlayer(int index){
		return this.players[index];
	}
	/** returns the positions of all the pawns on the board
	 * 
	 * @return an integer array of length 16. (Player 1:0-3 Player 2:4-7 Player 3:8-11 Player 4:12-15)
	 */
	public int[] getCurrentPositions(){
		int i=0;
		int result[] = new int[16];
		for(Player p:this.players){
			for(Pawn r:p.getPawns()){
				result[i] = r.getPosition();
				++i;
			}
		}
		return result;
	}
	/** Returns the number of pawns, for debugging only.
	 * 
	 * @return a string of the positions of the pawns of [player 1] [player 2] [player 3] [player 4]
	 */
	public String printCurrentPositions(){
		String result = "[";
		for(int i=0;i<this.getCurrentPositions().length;i++){
			result += this.getCurrentPositions()[i];
			if(i == 3 || i == 7 || i == 11){
				result += "] [";
			}else if(i==15){
				result += "]";
			}else{
				result += ",";
			}
		}
		return result;
	}
}