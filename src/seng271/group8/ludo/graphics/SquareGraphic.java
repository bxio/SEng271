/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import seng271.group8.ludo.model.BoardConfig;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class SquareGraphic implements LudoGraphic {
    
    private Square square;
    
    public SquareGraphic(Square square) {
        this.square = square;
    }
    
    public void paint(Graphics g, Dimension squareSize) {
        Graphics2D g2 = (Graphics2D)g;
        square.getGridIndex();
        int x = (square.getGridIndex()%BoardConfig.WIDTH)*squareSize.width;
        int y = (square.getGridIndex()/BoardConfig.WIDTH)*squareSize.width; // Int Division: eqv to Math.floor(a/b)
       // System.out.println("X pos is:" + x+ " Y pos:" + y + " Width is:" + squareSize.height);
        //g2.draw(new Rectangle2D.Double(x,y,squareSize.width,squareSize.height));
        g2.setColor(square.getColor());
        g2.fillOval(x,y,squareSize.width,squareSize.height);
    //   g2.drawRect(x, y, squareSize.width, squareSize.height);
    }
}
