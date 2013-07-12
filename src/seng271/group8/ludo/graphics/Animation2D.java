/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Point;

/**
 *
 * @author Alastairs
 */
public abstract class Animation2D {

    protected LudoGraphic graphic;
    protected long dur;
    protected Animation2D next, last;
    protected long elapsed = 0;
    
    
    public Animation2D(LudoGraphic g, long dur) {
        this.graphic = g;
        this.dur = dur;
    }
    
    // update properties to current state before starting
    public abstract void start();

    public Boolean tic(long dt) {
        Boolean done = false;
        
        elapsed+=dt;
        if(elapsed >= dur) {
            elapsed = dur;
            done = true;
        }
        
        return done;
    }
    
    protected Animation2D repeat() {
        return this;
    }
    
    protected Animation2D chain(Animation2D next) {
        this.next = next;
        this.next.last = this;
        return next;
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
