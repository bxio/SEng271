package seng271.group8.ludo.graphics;

import java.awt.Point;
import java.awt.geom.Point2D;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class TranslateAnimation extends Animation2D {
    
    private Square square;
    private Point2D start, dest, dir;
    private double distanceX;
    private double distanceY; 
    
    public TranslateAnimation(LudoGraphic g, Square s, long dur) {
        this(g, s.getPosition(),dur);
    }
    
    public TranslateAnimation(LudoGraphic g, Point dest, long dur) {
        super(g, dur);
       
        this.dest = dest;
    }
    
    @Override
    public void start() {
       super.start();
       this.start = graphic.getPosition(); 
       this.distanceX = this.dest.getX() - start.getX(); 
       this.distanceY = this.dest.getY() - start.getY();
       //System.out.println("des:" + this.dest.getY() + " start: " + this.start.getX() + " Distance: " + this.distanceY);
    }
    
    @Override
    public Boolean tic(long dt) {
        Boolean done = super.tic(dt);
        double x = Animation2D.easeInEaseOut(elapsed, start.getX(), distanceX, dur);
        double y = Animation2D.easeInEaseOut(elapsed, start.getY(), distanceY, dur);
        graphic.setPosition(new Point2D.Double(x,y));
        return done;
    }
}
