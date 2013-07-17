/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import seng271.group8.ludo.graphics.LudoGraphic;

/**
 *
 * @author alastair
 */
public class GameEntity {
    private LudoGraphic rendering;
    
    public void setRendering(LudoGraphic g) {
        this.rendering = g;
    }
    
    public LudoGraphic getRendering() {
        return this.rendering;
    }
}
