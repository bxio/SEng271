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
    
    private Pawn pawn;
    
    public PawnGraphic(Pawn pawn) {
        super(pawn.getSquare().getPosition());
        this.pawn = pawn;
        this.xPercent = this.yPercent = 0.5f;
       
    }

    @Override
    public void paint(Graphics g, Dimension squareSize) {
        Graphics2D g2 = (Graphics2D) g;
        
        Dimension size = this.getDrawSize(squareSize);
        Point pos = this.getDrawPosition(squareSize);

        g2.setColor(Color.BLACK);
        g2.fillOval(pos.x, pos.y, size.width, size.height);
        //System.out.println("Square Size " + squareSize.width + " Pawn s: " + size.width + " Pos :" + pos.x + " " + pos.y);
        //System.out.println("X " + (int)this.position.getX() + " Y " + (int)this.position.getY());
        //g2.setStroke( new BasicStroke (2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
       // g2.setColor(Color.BLACK);
       // g2.drawOval(x+ 10,y+10,squareSize.width - 20,squareSize.height - 20);*/
    }
}
