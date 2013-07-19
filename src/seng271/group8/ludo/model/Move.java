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
    
    public Move(Pawn pawn, LinkedList<Square> squares, int roll) {
        this.pawn = pawn;
        this.squares = squares;
        this.roll = roll;
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
