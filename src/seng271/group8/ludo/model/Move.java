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
    
    public Move() {
        
    }
    
    public Move(Pawn pawn, LinkedList<Square> squares, int roll) {
        this.pawn = pawn;
        this.squares = squares;
        this.roll = roll;
    }
    
    public void setHuman(Boolean b) {
        this.human = b;
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
    
    public LinkedList<Square> getSquares() {
        return this.squares;
    }
}
