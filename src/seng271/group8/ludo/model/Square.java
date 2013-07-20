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
	
    public Square(Grid type, Point position) {
        this.type = type;
        this.position = position;
    }
    
    public void setPawn(Pawn p) {
        this.pawn = p;
    }
    
    public Pawn getPawn() {
        return this.pawn;
    }
    
    public Color getColor() {
        return type.getColor();
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
