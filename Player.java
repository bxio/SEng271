/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bill
 */
public class Player {
	private String colour;
	private Pawn home[];
	private Strategy strategy;//set by giving value between 1 to 5
	/*
	(1)Aggressive: Give preference to a move that kicks a pawn;
	(2)Cautious: Give low priority to a move that kicks a pawn (so as not to anger the other
	player);
	(3)Defensive: Give preference to a move to a target field where the pawn cannot be kicked;
	(4)Move-first: Give preference to moving the foremost pawn;
	(5)Move-last: Give preference to moving the hindmost pawn.
	 */
	public void setColour(String colour){
		this.colour = colour;
	}
	public void setStrategy(int option){
		if(option == 1){
			this.strategy = new AggressiveStrategy();
		}else if(option == 2){
			this.strategy = new CautiousStrategy();
		}else if(option == 3){
			this.strategy = new DefensiveStrategy();
		}else if(option == 4){
			this.strategy = new MoveFirstStrategy();
		}else if(option == 5){
			this.strategy = new MoveLastStrategy();
		}
	}
	public void planMove(int roll){
		
	}
	
	public void executeMove(){
		
	}
}
