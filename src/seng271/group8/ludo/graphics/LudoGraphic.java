    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Observer;

/**
 *
 * @author Alastairs
 */
public abstract class LudoGraphic {
    protected Point2D position;
    protected float scale = 1;
    
    // Indicate the graphic should be
    // scaled to x,y percentage of a grid square
    protected float xPercent = 1;
    protected float yPercent = 1;
    protected Dimension lastSize;
    protected Point lastPosition;
     
   public LudoGraphic(Point p) {
        this.position = p;
    }
    
    public void setPosition(Point2D p) {
        //System.out.println("X :" + p.getX() + " Y : " + p.getY());
        this.position = p;
    }
    
    public Point2D getDrawPosition(Dimension squareSize) {
        Point2D p = new Point2D.Double((squareSize.width*(this.position.getX()+(1-this.xPercent*scale)/2f)), 
                    (squareSize.width*(this.position.getY()+(1-this.yPercent*scale)/2f)));
        return p;
    }
    
    public Point2D getDrawSize(Dimension squareSize) {
        Point2D d  = new Point2D.Double((this.xPercent*squareSize.width*scale), 
                (this.yPercent*squareSize.height*scale));
        return d;
    }
    
    public void setXPercent(float xPercent) {
        this.xPercent = xPercent;
    }
    
    public void setYPercent(float yPercent) {
        this.yPercent = yPercent;
    }
    
    public float getYPercent() {
        return this.yPercent;
    }
    
    public float getXPercent() {
        return this.xPercent;
    }
    
    public void setScale(float scale) {
        this.scale = scale;
    }
    
    public float getScale() {
        return this.scale;
    } 
    
    public Point2D getPosition() {
        return this.position;
    }
    
    public abstract void paint(Graphics g, Dimension squareSize);
}
