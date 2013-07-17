/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

/**
 *
 * @author Alastairs
 */
public class Move {
    private Square square;
    private Pawn pawn;
    private int roll;
    
    public Move(Pawn pawn, Square square, int roll) {
        this.pawn = pawn;
        this.square = square;
        this.roll = roll;
    }
    
    public Pawn getPawn() {
        return this.pawn;
    }
    
    public int getRoll() {
        return this.roll;
    }
    
    public Square getSquare() {
        return this.square;
    }
}
