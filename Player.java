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
	/** Initializes the player
	* 
	* @param colour The color of the player
	* @param strategy the strategy of the player
	* @param startingPosition the starting position of the player
	*/
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
		//System.out.println(this.colour+" [Start:"+this.start+"|Finish:"+this.finish[0]+"-"+this.finish[3]+ "] ready!");
	}
	/** Gets the player's pawn
	* 
	* @param i the position of the pawn to return
	* @return the player's i-th pawn
	*/
	public Pawn getPawn(int i){
		return this.pawns[i];
	}
	/** Returns all pawns of a player
	* 
	* @return an array of all the pawns belonging to that player
	*/
	public Pawn[] getPawns(){
		return this.pawns;
	}
	/** I have no idea what this does yet
	 * @return some string.
	*/
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
	/** Sets the color of the pawn
	* 
	* @param colour a string with the 
	*/
	public void setColour(String colour){
		this.colour = colour;
	}
	/** Returns the color of the pawn
	* 
	* @return a string containing the color of the pawn
	*/
	public String getColour(){
		return this.colour;
	}
	/** Sets the position of the player
	* 
	* @param position the integer of the player's starting position. If the integer is not
	* 1, 11, 21,or 31 the method will throw an exception.
	*/
	public void setStartingPosition(int position){
		if((position % 10 == 1) && position <=31){
			this.start = position;
		}else{
			throw new UnsupportedOperationException("Invalid startiong position Given!");
		}
	}
	/** Returns the starting position of the player
	* 
	* @return integer of the starting position of the player
	*/
	public int getStartingPosition(){
		return this.start;
	}
	/** Sets the Player's Strategy
	 * 
	 * @param option	Number of the strategy (from 0 to 6)
	 * 
	 *	0: Human Strategy
	 *	1: Aggressive Strategy
	 *	2: Cautious Strategy
	 *	3: Defensive Strategy
	 *	4: Move First Strategy
	 *	5: Move Last Strategy
	 *	6: Evil Strategy
	 */
	public void setStrategy(int option){
		if(option == 0){
			this.strategy = new HumanStrategy();
		}else if(option == 1){
			this.strategy = new AggressiveStrategy();
		}else if(option == 2){
			this.strategy = new CautiousStrategy();
		}else if(option == 3){
			this.strategy = new DefensiveStrategy();
		}else if(option == 4){
			this.strategy = new MoveFirstStrategy();
		}else if(option == 5){
			this.strategy = new MoveLastStrategy();
		}else if(option == 6){
			this.strategy = new BrutalStrategy();
		}else{
			throw new UnsupportedOperationException("Invalid Strategy option Given!");
		}
	}
	/** Returns the player's strategy
	* 
	* @return the player's strategy
	*/
	public Strategy getStrategy(){
		return this.strategy;
	}
	/** Returns the name of the player's strategy
	* 
	* @return the name of the strategy
	*/
	public String getStrategyName(){
		return this.strategy.getName();
	}
	/** Does the move recommended by the strategy.
	* 
	*/
	public void execute(){
		
	}
}