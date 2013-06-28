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
	private int start;
	private int finish[] = new int[4];
	private Strategy strategy;
	public void initPlayer(String colour, int strategy, int startingPosition){
		this.setColour(colour);
		this.setStrategy(strategy);
		this.setStartingPosition(startingPosition);
		for(int i=40;i<44;i++){
			this.finish[i-40] = this.start + i;
		}

		this.pawns = new Pawn[4];
		this.pawns[0] = new Pawn(this,-1);
		this.pawns[1] = new Pawn(this,-1);
		this.pawns[2] = new Pawn(this,-1);
		this.pawns[3] = new Pawn(this,-1);
		System.out.println(this.colour+" [Start:"+this.start+"|Finish:"+this.finish[0]+"-"+this.finish[3]+ "] ready!");
	}
	public Pawn getPawn(int i){
		return this.pawns[i];
	}
	public String getReport(){
		String result = "{"+this.colour+"-";
		for(int i=0;i<4;i++){
			if(this.pawns[i].getPosition() == -1){
				result = result.concat("["+i+":"+"Home]");
			}else{
				result = result.concat("["+i+":"+this.pawns[i].getPosition()+"]");
			}
		result = result.concat(" ");//space it out a little, shall we?
		}
		return result+"}";
	}
	public void setColour(String colour){
		this.colour = colour;
	}
	public String getColour(){
		return this.colour;
	}
	public void setStartingPosition(int position){
		if(position % 10 == 1){
			this.start = position;
		}else{
			throw new UnsupportedOperationException("Invalid startiong position Given!");
		}
	}
	public int getStartingPosition(){
		return this.start;
	}
	/** Sets the Player's Strategy
	 * 
	 * @param option	Number of the strategy (from 1 to 6)
	 */
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
	public void execute(){
		
	}
	
	public Player passTurn(){
		return null;
	}
}