/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Alastairs
 */
public class Square extends GameEntity {
    protected Grid type;
    protected Pawn pawn = null;
    protected Boolean selected = false;
    protected Color c; 
    public static final String PAWNLANDED = "PAWNLANDED";
    
    public Square(Grid type, Point position) {
        this.type = type;
        this.c = this.type.getColor();
        this.position = position;
    }
    
    public void setPawn(Pawn p) {
        Pawn oldPawn = this.pawn;
        this.pawn = p;
        this.pcs.firePropertyChange(PAWNLANDED, oldPawn, this.pawn);
    }
    
    public Grid getType() {
        return this.type;
    }
    
    public Pawn getPawn() {
        return this.pawn;
    }
    
    public Color getColor() {
        return c;
    }
    
    public Color getDefaultColor() {
        return this.type.getColor();
    }
    
    public void setColor(Color c) {
        this.c = c;
    }

    public Boolean isSlected() {
        return this.selected;
    }
    
    public Boolean canPass(Pawn pw) {
        return true;
    }
    
    public Boolean canOccupy(Pawn pw) {
        Boolean can = true;
        
        if(this.pawn != null) {
            if(this.pawn.getOwner().equals(pw.getOwner()))
                can = false;
        }
        return can;
    }
}
