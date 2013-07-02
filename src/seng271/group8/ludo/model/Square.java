/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.awt.Color;

/**
 *
 * @author Alastairs
 */
public class Square {
    protected Grid type;
    protected int gridIndex;
    protected Color color;
    private Pawn occupies;
	
    public Square(Grid type, int index) {
        this.type = type;
        this.gridIndex = index;
    }
    
    public Color getColor() {
        return type.getColor();
    }
    
    public int getGridIndex() {
        return gridIndex;
    }
}
