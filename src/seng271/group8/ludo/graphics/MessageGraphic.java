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

/**
 *
 * @author alastair
 */
public class MessageGraphic extends LudoGraphic {

    private String message;
    
    public MessageGraphic(Point p, String m) {
        super(p);
        message = m;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public void paint(Graphics g, Dimension squareSize) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setFont(new Font("Arial", Font.BOLD, 50));
        g2.setColor(Color.BLACK);
        g2.drawChars(message.toCharArray(), 0, message.length(), squareSize.width*5, squareSize.width*5);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 48));
        g2.drawChars(message.toCharArray(), 0, message.length(), squareSize.width*5+2, squareSize.width*5+10);
    }
    
}
