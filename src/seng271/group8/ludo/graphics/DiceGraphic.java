/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author alastair
 */
public class DiceGraphic extends LudoGraphic {

    public DiceGraphic(Point p) {
        super(p);
    }
    
    @Override
    public void paint(Graphics g, Dimension squareSize) {
        
        Graphics2D g2 = (Graphics2D)g;
        
        Point2D pos = getDrawPosition(squareSize);
        Point2D size = getDrawSize(squareSize);

        RoundRectangle2D bounds = new RoundRectangle2D.Double(
                squareSize.width*position.getX(),squareSize.height*position.getY(),
                squareSize.width, squareSize.height,30d,30d);
        g2.setColor(new Color(255,255,255));
        g2.fill(bounds);
        
    }
    
}
