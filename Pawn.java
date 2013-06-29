/**
 *
 * @author bill
 */
public class Pawn {
    private Player owner;
    private int currentPos;
	private boolean looped;
    public Pawn(Player owner, int currentPos){
		this.owner = owner;
		this.currentPos = currentPos;
		looped = false;
	}
	/** Sets the Pawn's Owner
	 * 
	 * @param owner	The Player whom the pawn belongs to
	 */
	public void setOwner(Player owner){
		this.owner = owner;
	}
	/** Returns the pawn's owner
	 * 
	 * @return the pawn's owner
	 */
    public Player getOwner(){
        return this.owner;
    }
	/** Returns the status of the pawn
	 * 
	 * @return the pawn's status
	 */
	public boolean getStatus(){
		return this.looped;
	}
	/** Sets the pawn's status
	 * 
	 * @param status The status you want the pawn to be. 
	 */
	public void setStatus(boolean status){
		this.looped = status;
	}
	
	/** Sets the pawn's position
	 * 
	 * @param position the position you want the pawn to bes
	 */
	public void setPosition(int position){
        this.currentPos = position;
    }
	
    /** Returns the pawn's position
	 * 
	 * @return the pawn's position
	 */
    public int getPosition(){
        return this.currentPos;
    }
	/** Moves the pawn forward.
	 * 
	 * @param pawns[] the size 16 array that contains the positions of the pawns
	 * @param spaces the amount of spaces the pawn moves forward
	 */
	public void move(int pawns[],int spaces){
		int position = this.currentPos;
		int start = this.owner.getStartingPosition();
		int target = position + spaces;
		int limit = start + 43;
		
		if(target >=limit - 4){
			target = target%40;
			this.looped = true;
		}
		
		if(this.looped && target >= start){
			target += 40;
		}
		//detect Collision
		int otherPlayer = -1, otherPawn = -1, location = -1;
		for(int i=0;i<pawns.length;i++){
			if(pawns[i]==target){
				location = i;
			}
		}
		System.out.print("Location is: "+location);
		if(location == -1){
			//No collision, no action required.
		}else{
			if(location <4){
				otherPlayer = 0;
			}else if(location<8){
				otherPlayer = 1;
				otherPawn = location - 4;
			}else if(location<12){
				otherPlayer = 2;
				otherPawn = location - 8;
			}else{
				otherPlayer = 3;
				otherPawn = location - 12;
			}
			System.out.print(" OtherPlayer: "+otherPlayer);
			System.out.print(" Location is now: "+otherPawn);

			//get opposing pawn and kick it
			Pawn otherPawnObject;
		}
		
		
		//System.out.println("Start:"+start+" Position:"+position+" End:"+target);
		this.currentPos = target;
	}
	
	public void start(){
		this.currentPos = this.owner.getStartingPosition();
	}
    public void returnHome(){
        //System.out.println("Pawn returning home.");
		this.currentPos = -1;
    }

}