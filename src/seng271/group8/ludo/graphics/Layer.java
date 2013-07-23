/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.lang.reflect.Array;

/**
 *
 * @author Alastairs
 */
public class Layer {
    private LudoGraphic[][] graphics;
    
    public Layer(int width, int height) {
        graphics = new LudoGraphic[width][height];
    }
    
    public LudoGraphic get(int x, int y) {
        return graphics[x][y];
    }
    
    public void add(LudoGraphic g, int x, int y) {
        graphics[x][y] = g;
    }
}
