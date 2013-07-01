/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

/**
 *
 * @author Alastairs
 * 
 * Defines the board area and square types.
 */
public class BoardConfig {
    
    public static final int WIDTH = 11;
    public static final int HEIGHT = 11;
    
    public static final Grid[] MAP = {
        Grid.P1_HOM,Grid.P1_HOM,Grid.EMP_SQ,Grid.EMP_SQ,Grid.SQUARE,Grid.P2_END,Grid.P2_STA,Grid.EMP_SQ,Grid.EMP_SQ,Grid.P2_HOM,Grid.P2_HOM,
        Grid.P1_HOM,Grid.P1_HOM,Grid.EMP_SQ,Grid.EMP_SQ,Grid.SQUARE,Grid.P2_GOA,Grid.SQUARE,Grid.EMP_SQ,Grid.EMP_SQ,Grid.P2_HOM,Grid.P2_HOM,
        Grid.P1_HOM,Grid.P1_HOM,Grid.EMP_SQ,Grid.EMP_SQ,Grid.SQUARE,Grid.P2_GOA,Grid.SQUARE,Grid.EMP_SQ,Grid.EMP_SQ,Grid.P2_HOM,Grid.P2_HOM,
        Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,Grid.SQUARE,Grid.P2_GOA,Grid.SQUARE,Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,
        Grid.P1_STA,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.P2_GOA,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,
        Grid.P1_END,Grid.P1_GOA,Grid.P1_GOA,Grid.P1_GOA,Grid.P1_GOA,Grid.CENTER,Grid.P3_GOA,Grid.P3_GOA,Grid.P3_GOA,Grid.P3_GOA,Grid.P3_END,
        Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.P4_GOA,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.SQUARE,Grid.P3_STA,
        Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,Grid.SQUARE,Grid.P4_GOA,Grid.SQUARE,Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,Grid.EMP_SQ,
        Grid.P4_HOM,Grid.P4_HOM,Grid.EMP_SQ,Grid.EMP_SQ,Grid.SQUARE,Grid.P4_GOA,Grid.SQUARE,Grid.EMP_SQ,Grid.EMP_SQ,Grid.P3_HOM,Grid.P3_HOM,
        Grid.P4_HOM,Grid.P4_HOM,Grid.EMP_SQ,Grid.EMP_SQ,Grid.SQUARE,Grid.P4_GOA,Grid.SQUARE,Grid.EMP_SQ,Grid.EMP_SQ,Grid.P3_HOM,Grid.P3_HOM,
        Grid.P4_HOM,Grid.P4_HOM,Grid.EMP_SQ,Grid.EMP_SQ,Grid.P4_STA,Grid.P4_END,Grid.SQUARE,Grid.EMP_SQ,Grid.EMP_SQ,Grid.P3_HOM,Grid.P3_HOM  
    };
}
