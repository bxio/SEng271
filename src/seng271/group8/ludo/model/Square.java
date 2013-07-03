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
public class Square {
    protected Grid type;
    protected Point position;
    private Pawn occupies;
	
    public Square(Grid type, Point position) {
        this.type = type;
        this.position = position;
    }
    
    public Color getColor() {
            return type.getColor();
    }
    
    public Point getPosition() {
        return position;
    }
}
