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
import java.util.List;
import seng271.group8.ludo.model.BoardConfig;
import seng271.group8.ludo.model.PathSegment;
import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;
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
    private List<IAnimatable> newAnimations;
    private List<IAnimatable> active;
    private List<LudoGraphic> graphics;
    private GamePanel game;
    
    public Renderer2D (GamePanel game) {
        this.game = game;
        this.graphics = new ArrayList<LudoGraphic>();
        this.active = new ArrayList<IAnimatable>();
        this.newAnimations = new ArrayList<IAnimatable>();

        for(Square s : game.getBoard().getSquareList()) {
            s.setRendering(new SquareGraphic(s));
            graphics.add(s.getRendering());
        }

        for(Pawn pw : game.getBoard().getPawnList()) {
            pw.setRendering(new PawnGraphic(pw));
            graphics.add(pw.getRendering());
        }

        /**
         *  Test animation setup here
         *  you can see animation chaining in action with the scaling and
         * translation moves
         * 
         */
        PawnGraphic pw = new PawnGraphic(new Pawn(new Player(5), 
                game.getBoard().getSquareList().get(0)));

        Animation2DSeries ani = new Animation2DSeries(2);
        TranslateAnimation trans = new TranslateAnimation(pw, new Point(0,6),1000);
        ani.add(trans);
        List<PathSegment> path = game.getBoard().getPlayer(1).getPath();
        
        for(int i = 0; i < path.size(); i ++) {
          ani.add(new TranslateAnimation(pw, 
                  path.get(i).getSquare().getPosition(),500));

        }
        
        this.addAnimation(ani);
        graphics.add(pw);
        
    }
    
    public void refresh(long dt) {
        
        List<IAnimatable> finished = new ArrayList<IAnimatable>();
        
        Iterator<IAnimatable> iter = newAnimations.iterator();
        while (iter.hasNext()) {
            IAnimatable a = iter.next();
                active.add(a);
                a.start();
                iter.remove();
        }
        
        for(IAnimatable a : active) {
            if(a.tic(dt))
                finished.add(a);
        }
        
        for(IAnimatable a : finished)
            active.remove(a);

        game.repaint();
    }
    
    public void addAnimation(IAnimatable animation) {
        this.newAnimations.add(animation);
    }
    
    public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       Toolkit.getDefaultToolkit().sync();
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   
       Dimension squareSize = computeSquareSize();
       
       for(LudoGraphic gr : graphics) {
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
        if(side % 2 != 0)
            side++;
        return new Dimension(side,side);
    }
}
