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
    
    public Player getOwner(){
        return this.owner;
    }
    
    public int getPosition(){
        return this.currentPos;
    }
    
    public void move(int roll){
        
    }
    
    public void returnHome(){
        System.out.println("Pawn returning home.");
        
    }
}
