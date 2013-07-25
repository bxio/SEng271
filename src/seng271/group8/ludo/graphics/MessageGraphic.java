/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author alastair
 */
public class MessageGraphic extends LudoGraphic {

    private String message;
    
    public MessageGraphic(Point p, String m) {
        super(p);
        message = m;
        this.scale = 0;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public void paint(Graphics g, Dimension squareSize) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, squareSize.width*11, squareSize.width*11);
        
        Point2D pos = this.getDrawPosition(squareSize);
        double x = pos.getX() + squareSize.getWidth()/2;
        double y = pos.getY() + squareSize.getWidth()/2;
        
        g2.setFont(new Font("Arial", Font.ITALIC, (int)(40*scale)));
        g2.setColor(Color.BLACK);
        int stringSize = g2.getFontMetrics().stringWidth(message);
        g2.drawChars(message.toCharArray(), 0, message.length(), (int)(x)-(stringSize/2), (int)(y));
        g2.drawChars(message.toCharArray(), 0, message.length(), (int)(x+5)-(stringSize/2), (int)(y+5));
        g2.setColor(Color.WHITE);
        g2.drawChars(message.toCharArray(), 0, message.length(), (int)(x+2)-(stringSize/2), (int)(y + 3));

    }
    
}
