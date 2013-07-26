/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.BoardConfig;

/**
 *
 * @author Alastairs
 */
public class BoardGraphic extends LudoGraphic {
    
    private BufferedImage boardBackground;
    
    public BoardGraphic(Point p) {
        super(p);
        
        try{
            boardBackground = ImageIO.read(Renderer2D.class.getResource("wood.png"));
        } catch (Exception e) {
            System.out.println("Board background didn't load: " + e.getMessage());
        }
        
    }

    @Override
    public void paint(Graphics g, Dimension squareSize) {
       Graphics2D g2 = (Graphics2D) g;
       
       int boardWidth = (int)squareSize.getWidth()*BoardConfig.WIDTH;
       int boardHeight = (int)squareSize.getHeight()*BoardConfig.HEIGHT;
       
       for(int x = 0; x < boardWidth; x+=boardBackground.getWidth()) {
           for(int y = 0; y < boardHeight; y+=boardBackground.getHeight()) {
               g2.drawImage(boardBackground, x, y, null);
           }
       }
       
       g2.setColor(new Color(101,67,33));
       g2.setStroke(new BasicStroke(10.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
       g2.drawRect(0, 0, boardWidth, boardHeight);
       g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
       g2.setColor(new Color(255,255,240));
       g2.drawRect(2, 2, boardWidth-4, boardHeight-4);
       
    }
   
}
