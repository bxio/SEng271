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
import seng271.group8.ludo.model.Pawn;

/**
 *
 * @author Alastairs
 */
public class PawnGraphic extends LudoGraphic{
    
    public PawnGraphic(Pawn pawn) {
        super(new Point(0,0));
        this.xPercent = this.yPercent = 0.5f;
       
    }
    
    public void paint(Graphics g, Dimension squareSize) {
        Graphics2D g2 = (Graphics2D) g;
        
        Dimension size = this.getDrawSize(squareSize);

        g2.setColor(Color.BLACK);
        g2.fillOval((int)(this.position.getX()*squareSize.width), (int)(this.position.getY()*squareSize.height), size.width, size.height);
        //System.out.println("X " + (int)this.position.getX() + " Y " + (int)this.position.getY());
        //g2.setStroke( new BasicStroke (2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
       // g2.setColor(Color.BLACK);
       // g2.drawOval(x+ 10,y+10,squareSize.width - 20,squareSize.height - 20);*/
    }
}
