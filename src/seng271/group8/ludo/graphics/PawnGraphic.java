/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import seng271.group8.ludo.model.ColorConfig;
import seng271.group8.ludo.model.Pawn;

/**
 *
 * @author Alastairs
 */
public class PawnGraphic extends LudoGraphic{
    
    private Pawn pawn;
 
    public PawnGraphic(Pawn pawn) {
        super(pawn.getSquare().getPosition());  
        this.gameEntity = this.pawn = pawn;
        this.xPercent = this.yPercent =0.5f;
       
    }

    @Override
    public void paint(Graphics g, Dimension squareSize) {
        Graphics2D g2 = (Graphics2D) g;
        
        Point2D size = this.getDrawSize(squareSize);
        Point2D pos = this.getDrawPosition(squareSize);
        Ellipse2D shape = new Ellipse2D.Double(pos.getX(), pos.getY(), size.getX(), size.getY());
        this.setLastDrawPositin(position);
//        g2.setColor(Color.red);
//        g2.drawRect((int)lastPosition.getX(), (int)lastPosition.getY(), squareSize.width, squareSize.height);
        float[] rgb = new float[3];
        ColorConfig.PLAYER_COLORS[pawn.getOwner().getId()].getRGBColorComponents(rgb);
        g2.setColor(ColorConfig.PLAYER_COLORS[pawn.getOwner().getId()]);
        //g2.setColor(new Color(rgb[0],rgb[1],rgb[2],0.5f));
        g2.fill(shape);
        
//        g2.setColor(Color.gray);
//        g2.draw(shape);
       
    }
    
//    @Override
//    public void setDirty(Boolean dirty) {
//        this.dirty = true;
//    }
}
