/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */
package seng271.group8.ludo.graphics;

/**
 *
 * @author Alastairs
 */
public abstract class Animation2D implements IAnimatable {

    protected LudoGraphic graphic;
    protected long dur;
    protected long elapsed = 0;
    protected int repeats = 0, seriesRepeat = 0,currentRepeat = 0, currentSeriesRepeat = 0;
    
    public Animation2D(LudoGraphic g, long dur) { 
       this.graphic = g;
       this.dur = dur;
    }
    
    // update properties to current state before starting
    public void start() {
        this.elapsed = 0;
        this.graphic.setDirty(true);
    }

    public Boolean tic(long dt) {
        Boolean done = false;
        this.graphic.setDirty(true);
        
        elapsed+=dt;
        if(elapsed >= dur) {
            elapsed = dur;
            done = true;
            graphic.setDirty(false);
        }
        
        return done;
    }
    
    /**
     * Repeats this animation n times
     * @param n 
     */
    protected void repeat(int n) {
        
    }
   
    /**
     * Repeats this animation until canceled.
     * 
     * @return 
     */
    protected int repeat() {
        return this.repeats;
    }
    
    /***
     *  For info on these functions see: 
     *  https://github.com/jesusgollonet/processing-penner-easing
     */
    protected static double linear(double t, double b, double c, double d) {
        return c*t/d + b;
    }
    
    protected static double easeInEaseOut(double t, double b, double c, double d) {
        if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
        return -c/2 * ((t-=2)*t*t*t - 2) + b;   
    }
    
    protected static double sinEaseInOut(double t,double b , double c, double d) {
		return -c/2 * ((float)Math.cos(Math.PI*t/d) - 1) + b;
    }
}
