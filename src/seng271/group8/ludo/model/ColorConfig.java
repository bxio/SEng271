/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.awt.Color;
import java.util.EnumMap;
import java.util.HashMap;

/**
 *
 * @author Alastairs
 */
public class ColorConfig {

    // Player colors
    public static Color P1_COLOR = new Color(12,23,34);
    public static Color P2_COLOR;
    public static Color P3_COLOR;
    public static Color p4_COLOR;
 
    
    // Square colors
    public static Color P1_SQ_COLOR = Color.BLUE;
    public static Color P2_SQ_COLOR = Color.YELLOW;
    public static Color P3_SQ_COLOR = Color.GREEN;
    public static Color P4_SQ_COLOR = Color.RED;
    public static Color EMPTY_SQ = Color.GRAY;
    public static Color SQUARE = Color.WHITE;
    
   /* public static EnumMap<Grid, Color> squareColors;
    
    static {
        squareColors = new EnumMap<Grid, Color>();
        
        squareColors.put(Grid.P1_STA, P1_COLOR);
        squareColors.put(Grid.P1_GOA, P1_COLOR);
        squareColors.put(Grid.P2_STA, P2_COLOR);
        squareColors.put(Grid.P2_GOA, P2_COLOR);
        squareColors.put(Grid.P3_STA, P3_COLOR);
        squareColors.put(Grid.P3_GOA, P3_COLOR);
        squareColors.put(Grid.P4_STA, P4_COLOR);
        squareColors.put(Grid.P4_GOA, P4_COLOR);
        
        squareColors.put(Grid.P4_END, EMPTY_SQ);
        
        
            P2_HOM
            P3_HOM:
            P4_HOM:
            P1_STA:
            cP2_STA:
            P3_STA:
            P4_STA:
            P1_GOA:
            P2_GOA:
            P3_GOA:
            P4_GOA:
            EMP_SQ:
            SQUARE:
            CENTER:
            P1_END:
            P2_END:
            P3_END:
            P4_END:
        
    }
    
    public static Color getColorForSquare(Grid g) {
        return ColorConfig.squareColors.get(g);
    }*/
}