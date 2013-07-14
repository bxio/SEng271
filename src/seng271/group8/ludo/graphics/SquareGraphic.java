/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class SquareGraphic extends LudoGraphic {
    
    private Square square;
    
    public SquareGraphic(Square square) {
        super(square.getPosition());
        this.square = square;
        this.xPercent = this.yPercent = 0.7f;
    }
    
    @Override
    public void paint(Graphics g, Dimension squareSize) {
        Graphics2D g2 = (Graphics2D)g;
        
        Point pos = getDrawPosition(squareSize);
        Dimension size = getDrawSize(squareSize);

        //g2.draw(new Rectangle2D.Double(x,y,squareSize.width,squareSize.height));
        //g2.drawRect(x, y, squareSize.width, squareSize.height);
        
        g2.setColor(square.getColor());
        g2.fillOval(pos.x,pos.y,size.width,size.height);
        g2.setStroke( new BasicStroke (2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(Color.BLACK);
        g2.drawOval(pos.x,pos.y,size.width,size.height);
        //drawDebugIndexes(g2, x ,y);
        
    }
    
    private void drawDebugIndexes(Graphics2D  g2, int x, int y) {
        String xyCoords = Integer.toString(square.getPosition().x) + "," + Integer.toString(square.getPosition().y);
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.drawChars(xyCoords.toCharArray(), 0, xyCoords.length(), x+20, y+40);
    }
}
