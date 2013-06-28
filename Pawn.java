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
	
	public void setOwner(Player owner){
		this.owner = owner;
	}
    public Player getOwner(){
        return this.owner;
    }
    
    public int getPosition(){
        return this.currentPos;
    }
	public void setPosition(int position){
        this.currentPos = position;
    }
	
	public void move(int spaces){
		int potential;
		potential = (this.currentPos + spaces)%40;
		if(potential >= this.owner.getStartingPosition()){
			//pawn moved too far!
			potential = this.owner.getStartingPosition()-1+spaces;
		}
		System.out.println("Original:"+this.currentPos+" New:"+potential);
		this.currentPos = potential;
	}
	public void start(){
		this.currentPos = this.owner.getStartingPosition();
	}
    public void returnHome(){
        //System.out.println("Pawn returning home.");
		this.currentPos = -1;
    }

}
