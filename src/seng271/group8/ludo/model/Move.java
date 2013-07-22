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
    private Pawn pawn;
    private int roll;
    private LinkedList<Square> squares;
    private Boolean human = false;
    private Boolean kick = false;
    private Move kickMove;
    
    public Move() {
        
    }
    
    public Move(Pawn pawn, LinkedList<Square> squares) {
        this(pawn,squares,-1);
    }
    
    public Move(Pawn pawn, LinkedList<Square> squares, int roll) {
        this.pawn = pawn;
        this.squares = squares;
        this.roll = roll;
    }
    
    public void setHuman(Boolean b) {
        this.human = b;
    }
    
    public void setKickMove(Move kick) {
        this.kick = true;
        this.kickMove = kick;
    }
    
    public Move getKickMove() {
        return this.kickMove;
    }
    
    public Boolean isHuman() {
        return human;
    }
    
    public Pawn getPawn() {
        return this.pawn;
    }
    
    public int getRoll() {
        return this.roll;
    }
    
    public Boolean doesKick() {
        return this.kick;
    }
    
    public Pawn getKicked() {
        return squares.getLast().getPawn();
    }
    
    public LinkedList<Square> getSquares() {
        return this.squares;
    }
}
