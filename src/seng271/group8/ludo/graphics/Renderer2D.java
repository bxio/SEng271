/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
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
    private Dimension panelSize = new Dimension(100,100);
    private Dimension squareSize = new Dimension(100,100);
    private Boolean repaintAll = true;
    private BufferedImage scene;
    private Graphics2D g2d;
    
    public Renderer2D () {
        this.graphics = new ArrayList<LudoGraphic>();
        
    }
    
    public void add(LudoGraphic g) {
       graphics.add(g);
    }
    
    public void addLayer(Layer l) {

    }
    
    public void resize( Dimension panelSize) {
        this.panelSize = panelSize;
        this.computeSquareSize(panelSize);
        this.repaintAll = true;
    }
      
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();


        // If the view size has changed need to recompute the entire view
        // All drawing is done to a buffered image which is then copied to the 
        // Panel area
         int viewSize = (int)Math.min(panelSize.getWidth(),panelSize.getHeight());
         if(scene == null 
                 || scene.getWidth() != viewSize ) {
             scene = new BufferedImage(viewSize, viewSize, BufferedImage.TYPE_INT_ARGB);
             g2d = scene.createGraphics();
             g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
             g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
             g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         }

        List<Rectangle.Double> regions = computeDirtyRegions();
        if(!repaintAll){
            // Clear all dirty areas
           for (Rectangle.Double ar : regions) {
                g2d.clearRect((int)ar.x, (int)ar.y, (int)( ar.width), (int)( ar.height));
           }
        } else {
            // Clear entire board (window as resized)
            g2d.clearRect(0, 0, squareSize.width*11, squareSize.width*11);
        }
        
        // Now redraw all dirty graphics
        for(LudoGraphic gr : graphics) {
            if(!repaintAll){
                if(gr.getDirty()) {
                     gr.paint(g2d, squareSize);
                     gr.setDirty(false);
                 }
            }
            else {
                // otherwise redraw entire board
                gr.paint(g2d, squareSize);
            }
        }
        
        // Center board in panel
        g2.translate((panelSize.width-viewSize)/2, 0);
        // Draw the buffered image to the panel
        g2.drawImage(scene, g2d.getTransform(), null);
        repaintAll = false;
// Some Debug drawing code
//      g2.clearRect(0, 0, squareSize.width*11, squareSize.width*11);
//      for (Rectangle.Double ar : regions) {
//          g2.drawRect((int)ar.x, (int)ar.y, (int)( ar.width), (int)( ar.height));
//      }

    }
    
    public List<Rectangle.Double> computeDirtyRegions() {
        List<LudoGraphic> dirty = new ArrayList<LudoGraphic>();
        List<Rectangle.Double> regions = new ArrayList<Rectangle.Double>();

        // Find all dirty graphics
        for(LudoGraphic gr : graphics) {
          if(gr.getDirty()) {
             dirty.add(gr);
          }  
        }
        
        // Compute any other graphics that may overlap with them
        // They will need to be redrawn as well
        findRedrawAreas(dirty, regions);          
        return regions;
    }
    
    public void findRedrawAreas(List<LudoGraphic> dirty, List<Rectangle.Double> dirtyRegions) {
        Point2D size = new Point2D.Double(squareSize.width,squareSize.height);
            
        // For each Dirty graphic check its last and new position
        // Find other graphics whose bounds overlap
        // These regions need to be redrawn
        for(LudoGraphic dr : dirty) {
            Point2D paCur = dr.getBounds(squareSize);
            Point2D paOld = dr.getLastBounds(squareSize);              
            
            for(LudoGraphic ov : graphics) {
                Point2D pbCur = ov.getBounds(squareSize);            

                if(checkForOverlap(paCur, pbCur, size, size)
                   || checkForOverlap(paOld, pbCur, size, size)) {
                    ov.setDirty(true);
                    dirtyRegions.add(new Rectangle.Double(pbCur.getX(), pbCur.getY(),
                    size.getX(), size.getY()));
                }
                
            }
        }

    }
    
    public Boolean checkForOverlap(Point2D pa, Point2D pb, Point2D sa, Point2D sb) {
        Boolean overlap = false;
        
        // Condition for overlap of two rectangles
        if(pa.getX() < (pb.getX()+sb.getX())
           && pa.getX() + sa.getX() > pb.getX()
           && pa.getY() < (pb.getY()+ sb.getY())
           && pa.getY()+sa.getY() > pb.getY()) {
                overlap = true;
            }
        return overlap;
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
