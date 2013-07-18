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
    protected Point position;
    private Pawn pawn = null;
    private Boolean selected = false;
	
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
    
    public Point getPosition() {
        return position;
    }
    
    public Boolean isSlected() {
        return this.selected;
    }
    
    public void setSelected(Boolean selected) {
        this.selected = selected;
        pcs.firePropertyChange("highlight", selected, this.selected);
    }
    
    public Boolean canPass(Pawn pw) {
        return true;
    }
    
    public Boolean canOccupy(Pawn pw) {
        return true;
    }
}
