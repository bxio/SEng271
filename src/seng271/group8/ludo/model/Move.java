/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.util.LinkedList;

/**
 *
 * @author Alastairs
 */
public class Move {
    private Pawn pawn;///< the pawn to be moved
    private int roll;///< the number rolled
    private LinkedList<Square> squares;///< the squares that the pawn pass through. We need this in order to animate the moves on the board.
    private Boolean human = false;///< used in RollHandler to make the human strategy asychronous
    private Boolean kick = false;///< whether the move will kick another pawn
    private Boolean movingFromHome = false;///< whether the pawn is moving from their home
	private Move kickMove;///< the move of the pawn after it's kicked
    
    public Move() {
        
    }
    
    //Squares passed for animation
    public Move(Pawn pawn, LinkedList<Square> squares) {
        this(pawn,squares,-1);
    }
    
    public Move(Pawn pawn, LinkedList<Square> squares, int roll) {
        this.pawn = pawn;
        this.squares = squares;
        this.roll = roll;
    }
    /** Sets whether the pawn's human boolean
	 * 
	 * @param b whether this pawn belongs to a human or not
	 */
    public void setHuman(Boolean b) {
        this.human = b;
    }
    /** 
	 * 
	 * @param kick The kicked pawn's move
	 */
    public void setKickMove(Move kick) {
        this.kick = true;
        this.kickMove = kick;
    }
    
    public Move getKickMove() {
        return this.kickMove;
    }
    /** 
	 * 
	 * @return whether this pawn belongs to a human
	 */
    public Boolean isHuman() {
        return human;
    }
    
    /** Sets whether the pawn is moving from their home
   	 * 
   	 * @param movingFromHome whether this pawn is moving from their home
   	 */
	public void setMovingFromHome(Boolean movingFromHome) {
		this.movingFromHome = movingFromHome;
	}
    
    /** 
	 * 
	 * @return	whether this pawn is moving from their home
	 */
    public Boolean isMovingFromHome() {
		return movingFromHome;
	}
	
    /** 
	 * 
	 * @return			the pawn to be moved
	 */
    public Pawn getPawn() {
        return this.pawn;
    }
    /** 
	 * 
	 * @return whether this pawn belongs to a human
	 */
    public int getRoll() {
        return this.roll;
    }
    /** 
	 * 
	 * @return whether performing this move will kick another pawn
	 */
    public Boolean doesKick() {
        return this.kick;
    }
    /** 
	 * 
	 * @return the pawn that is about to be kicked
	 */
    public Pawn getKicked() {
        return squares.getLast().getPawn();
    }
    /** 
	 * Squares is a list of squares that the Pawn passes through as it moves. 
	 * This method returns them so that they can be animated by the game UI.
	 * 
	 * @return the squares to be animated
	 */
    public LinkedList<Square> getSquares() {
        return this.squares;
    }
}
