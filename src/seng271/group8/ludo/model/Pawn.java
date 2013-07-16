package seng271.group8.ludo.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bill
 */
public class Pawn extends GameEntity {
    private Player owner;
    private Square square;
    
    public Pawn(Player player, Square pos){
        this.owner = player;
        this.square  = pos;
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
    public Square getPosition(){
        return this.square;
    }
    
    public void setPosition(Square position){
        if(this.square != null)
            this.square.setPawn(null);
        this.square = position;
    }
    
    public void move(int spaces){

    }
    
    public void start(){

    }
    
    public void returnHome(){

    }

}
