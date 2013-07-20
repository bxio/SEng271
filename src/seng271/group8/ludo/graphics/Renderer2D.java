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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import seng271.group8.ludo.model.BoardConfig;

/**
 *
 * @author Alastairs
 */
public class Renderer2D {
    

    private List<LudoGraphic> graphics;
    private Dimension squareSize = new Dimension(100,100);
    
    public Renderer2D () {
        this.graphics = new ArrayList<LudoGraphic>();
        /**
         *  Test animation setup here
         *  you can see animation chaining in action with the scaling and
         * translation moves
         * 
         */
        /*PawnGraphic pw = new PawnGraphic(new Pawn(new Player(5), 
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
        graphics.add(pw);*/
        
    }
    
    public void add(LudoGraphic g) {
       graphics.add(g);
    }
    
    public void resize( Dimension panelSize) {
        this.computeSquareSize(panelSize);
    }
      
    public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       Toolkit.getDefaultToolkit().sync();
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

       for(LudoGraphic gr : graphics) {
           gr.paint(g2, squareSize);
       }

    }
    
    public Point graphicToGridCoords(double x, double y) {
        Point p = new Point((int)x/squareSize.width, (int)y/squareSize.height);
        return p;
    }
    
    private void computeSquareSize(Dimension panelSize) {
        int side = Math.min(panelSize.width, panelSize.height)/BoardConfig.WIDTH;
        this.squareSize.setSize(side, side);
    }
}
