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
	private Pawn pawns[];
	private int startingPosition;
	private Strategy strategy;//set by giving value between 1 to 5
	/*
	(1)Aggressive: Give preference to a move that kicks a pawn;
	(2)Cautious: Give low priority to a move that kicks a pawn (so as not to anger the other
	player);
	(3)Defensive: Give preference to a move to a target field where the pawn cannot be kicked;
	(4)Move-first: Give preference to moving the foremost pawn;
	(5)Move-last: Give preference to moving the hindmost pawn.
	 */
	
	public void initPlayer(String colour, int strategy, int startingPosition){
		this.setColour(colour);
		this.setStrategy(strategy);
		this.setStartingPosition(startingPosition);
		this.pawns = new Pawn[4];
		this.pawns[0] = new Pawn();
		this.pawns[1] = new Pawn();
		this.pawns[2] = new Pawn();
		this.pawns[3] = new Pawn();
		for(Pawn p: this.pawns){
			p.returnHome();
			p.setOwner(this);
		}
	}
	public String getCurrentPawnPositions(){
		String result = "";
		for(int i=0;i<4;i++){
			if(this.pawns[i].getPosition() == -1){
				result = result.concat("["+i+":"+"Home]");
			}else{
				result = result.concat("["+i+":"+this.pawns[i].getPosition()+"]");
			}
		result = result.concat(" ");//space it out a little, shall we?
		}
		return "{"+result+"}";
	}
	public void setColour(String colour){
		this.colour = colour;
	}
	public String getColour(){
		return this.colour;
	}
	public void setStartingPosition(int position){
		if(position % 10 == 1){
			this.startingPosition = position;
		}else{
			throw new UnsupportedOperationException("Invalid startiong position Given!");
		}
	}
	public int getStartingPosition(){
		return this.startingPosition;
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
		}else{
			throw new UnsupportedOperationException("Invalid Strategy option Given!");
		}
	}
	public String getStrategy(){
		return this.strategy.getName();
	}
	public void planMove(int roll){
		this.strategy.getMoves(roll);
	}
	
	public void executeMove(){
		
	}
}
