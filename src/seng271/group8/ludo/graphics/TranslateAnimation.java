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
    private Point2D start, dest;
    private double distance;
    
    public TranslateAnimation(LudoGraphic g, Square s, long dur) {
        this(g, s.getPosition(),dur);
    }
    
    public TranslateAnimation(LudoGraphic g, Point dest, long dur) {
        super(g, dur);
        
        this.start = graphic.getPosition();
        this.dest = dest;
        this.distance = start.distance(this.dest); 
    }
    
    public Boolean tic(long dt) {
        Boolean done = super.tic(dt);
        double x = Animation2D.easeInEaseOut(elapsed, start.getX(), distance, dur);
        double y = Animation2D.easeInEaseOut(elapsed, start.getY(), distance, dur);
        graphic.setPosition(new Point2D.Double(x,y));
        return done;
    }
}
