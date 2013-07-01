package seng271.group8.ludo.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bill
 */
public class Pawn {
    private Player owner;
    private int currentPos;
    public Pawn(Player owner, int currentPos){
		this.owner = owner;
		this.currentPos = currentPos;
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
    /** Returns the pawn's position
	 * 
	 * @return the pawn's position
	 */
    public int getPosition(){
        return this.currentPos;
    }
	public void setPosition(int position){
        this.currentPos = position;
    }
	
	public void move(int spaces){
		int position = this.currentPos;
		int start = this.owner.getStartingPosition();
		int target = position + spaces;
		int limit = start + 43;
		System.out.println("Start: "+start+" Position: "+position+" Move: "+spaces+" Target: "+target);
		if(target>start+39){
			System.out.print("Wrapped around board once. ");
			target = target - 40 - this.owner.getStartingPosition()+spaces;
			System.out.println("Target corrected to "+target);
			if(target > limit){
				target = limit;
				System.out.println("Limit reached. Corrected to "+target);
			}
		}else{
			position = target;
			System.out.println("Target is "+target);
		}
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
