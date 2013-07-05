/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import seng271.group8.ludo.model.BoardConfig;
import seng271.group8.ludo.model.Square;
import seng271.group8.ludo.ui.GamePanel;

/**
 *
 * @author Alastairs
 */
public class Renderer2D {
    // will eventually move the drawing code from game panel here
    // game panel will probably get large handling all the click events
    // for the board
    private ArrayList<Animation2D> active;
    private ArrayList<LudoGraphic> graphics;
    private GamePanel game;
    
    public Renderer2D (GamePanel game) {
        this.game = game;
        this.graphics = new ArrayList<LudoGraphic>();
        this.active = new ArrayList<Animation2D>();
        
        for(Square s : game.getBoard().getSquareList()) {
            graphics.add(new SquareGraphic(s));
        }
        
        PawnGraphic pw = new PawnGraphic(null);
        ScaleAnimation s = new ScaleAnimation(pw, 2,2500);
        s.chain(new ScaleAnimation(pw,1,2500));
        active.add(s);
        active.add(new TranslateAnimation(pw, new Point(6,6),5000));
        graphics.add(pw);
        
    }
    
    public void refresh(long dt) {
        
        ArrayList<Animation2D> finished = new ArrayList<Animation2D>();
        ArrayList<Animation2D> starting = new ArrayList<Animation2D>();
        
        for(Animation2D a : active) {
            if(a.tic(dt)) {
                if(a.next != null)
                    starting.add(a.next);
                finished.add(a);
            }    
        }
        for(Animation2D a : finished)
            active.remove(a);
        
        for(Animation2D a : starting)
            active.add(a);
        
        /* Nicer solution?
         * 
         * Iterator<Animation2D> iter = active.iterator();
        while (iter.hasNext()) {
            Animation2D a = iter.next();
            if(a.tic(dt)) {
                if(a.next != null)
                    
                iter.remove();
            }
        }*/
        
        game.repaint();
    }
    
    public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       Toolkit.getDefaultToolkit().sync();
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   
       Dimension squareSize = computeSquareSize();
       
       for(LudoGraphic gr : graphics) {
           //AffineTransform at = new AffineTransform();
           ///at.shear(-.5, 0);
           //g2.setTransform(at);
           gr.paint(g, squareSize);
       }
       
       g.dispose();
    }
    
    public Point graphicToGridCoords(double x, double y) {
        Point p = new Point((int)x/this.computeSquareSide(), (int)y/this.computeSquareSide());
        return p;
    }
    
    private int computeSquareSide() {
        return Math.min(game.getHeight(), game.getWidth())/BoardConfig.WIDTH;
    }
    
    private Dimension computeSquareSize() {
        int side = Math.min(game.getHeight(), game.getWidth())/BoardConfig.WIDTH;
        return new Dimension(side,side);
    }
}
