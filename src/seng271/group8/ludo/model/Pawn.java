package seng271.group8.ludo.model;

import java.awt.Color;
import java.awt.Point;

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
    private Move move;
    public int id = 0;
    public static final String MOVE = "MOVE";
    
    public Pawn(Player player, Square pos){
        this.owner = player;
        this.square  = pos;
        pos.setPawn(this);
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
    
    /** Returns the pawn's square
    * 
    * @return the pawn's position
    */
    public Square getSquare(){
        return this.square;
    }
    
    public void setMove(Move m) {
        Move old = this.move;
        this.move = m;
        this.setPosition(m.getSquares().getLast());
        pcs.firePropertyChange(MOVE, old, move);
    }
    
    public Move getMove() {
        return this.move;
    }
    
    public void setPosition(Square position){
        if(this.square != null)
            this.square.setPawn(null);
        this.square = position;
        this.square.setPawn(this);
    }
    
    @Override
    public Point getPosition() {
        return this.square.getPosition();
    }
    
    public void move(int spaces){

    }
    
    public void start(){

    }
    
    public void returnHome(){

    }

}
