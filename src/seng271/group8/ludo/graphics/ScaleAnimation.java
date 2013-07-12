/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

/**
 *
 * @author Alastairs
 */
public class ScaleAnimation extends Animation2D {
   
    float targetScale;
    float startScale;
    
    public ScaleAnimation(LudoGraphic g, float scale, long dur) {
        super(g, dur);
        this.targetScale = scale;
       // System.out.println("Target Scale is:" + scale + " Start is : " + this.startScale);
    }
    
    public void start() {
        this.startScale = graphic.getScale();
    }
    
    public Boolean tic(long dt) {
        Boolean done = super.tic(dt);
        this.graphic.setScale((float)Animation2D.sinEaseInOut(elapsed, startScale, 
               targetScale - startScale, dur));
        
        return done;
    }
}
 