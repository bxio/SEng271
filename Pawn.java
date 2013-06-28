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
		
	}
	public void start(){
		this.currentPos = this.owner.getStartingPosition();
	}
    public void returnHome(){
        //System.out.println("Pawn returning home.");
		this.currentPos = -1;
    }

}
