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
import java.util.LinkedList;
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
    private ArrayList<Animation2D> newAnimations;
    private ArrayList<Animation2D> active;
    private ArrayList<LudoGraphic> graphics;
    private GamePanel game;
    
    public Renderer2D (GamePanel game) {
        this.game = game;
        this.graphics = new ArrayList<LudoGraphic>();
        this.active = new ArrayList<Animation2D>();
        this.newAnimations = new ArrayList<Animation2D>();
        
        for(Square s : game.getBoard().getSquareList()) {
          graphics.add(new SquareGraphic(s));
        }
        
        /**
         *  Test animation setup here
         *  you can see animation chaining in action with the scaling and
         * translation moves
         * 
         */
        PawnGraphic pw = new PawnGraphic(null);
        ScaleAnimation s = new ScaleAnimation(pw, 2,2500);
       // s.chain(new ScaleAnimation(pw,1,2500));
        TranslateAnimation trans = new TranslateAnimation(pw, new Point(0,6),1000);
        LinkedList<Square> path = game.getBoard().getPaths().get(0);
        TranslateAnimation temp = trans;
        for(int i = 0; i < path.size(); i ++) {
            temp = (TranslateAnimation)temp.chain(new TranslateAnimation(pw, path.get(i).getPosition(),1000));
       
         }
       // this.addAnimation(s);
        this.addAnimation(trans);
        
        graphics.add(pw);
        
    }
    
    public void refresh(long dt) {
        
        ArrayList<Animation2D> finished = new ArrayList<Animation2D>();
        
        Iterator<Animation2D> iter = newAnimations.iterator();
        while (iter.hasNext()) {
            Animation2D a = iter.next();
                active.add(a);
                 a.start();
                iter.remove();
        }
        
        for(Animation2D a : active) {
            if(a.tic(dt)) {
                if(a.next != null)
                    newAnimations.add(a.next);
                finished.add(a);
            }    
        }
        
        for(Animation2D a : finished)
            active.remove(a);
       // try {
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
            /*
             EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
              
                }
            });*/
                  game.repaint();
        /*} catch (InvocationTargetException ex) {
            Logger.getLogger(Renderer2D.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void addAnimation(Animation2D animation) {
        this.newAnimations.add(animation);
    }
    
    public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       Toolkit.getDefaultToolkit().sync();
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   
       Dimension squareSize = computeSquareSize();
       
       for(LudoGraphic gr : graphics) {
           //AffineTransform at = new AffineTransform();
           ///at.shear(-1.5, 0);
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
