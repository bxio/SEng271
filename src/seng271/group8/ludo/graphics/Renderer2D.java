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
        //List<Rectangle.Double> regions = computeDirtyRegions();
        for (Rectangle.Double ar : regions) {
            g2d.clearRect((int)ar.x, (int)ar.y, (int)( ar.width), (int)( ar.height));
        }
      } else {
          g2d.clearRect(0, 0, squareSize.width*11, squareSize.width*11);
      }
       
       for(LudoGraphic gr : graphics) {
           if(!repaintAll){
               if(gr.getDirty()) {
                    Point2D pos = gr.getDrawPosition(squareSize);
                    Point2D size = gr.getDrawSize(squareSize);
                    gr.paint(g2d, squareSize);
                    gr.setDirty(false);
                }
           }
           else {
               
               gr.paint(g2d, squareSize);
           }
       }
       g2.translate((panelSize.width-viewSize)/2, 0);
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

        for(LudoGraphic gr : graphics) {
          if(gr.getDirty()) {
             dirty.add(gr);
          }  
        }
        
        for(LudoGraphic dr : dirty) {
            Point2D dirPos = dr.getBounds(squareSize);            
            Point2D dirSize = new Point2D.Double(squareSize.width,squareSize.height);
            
            for(LudoGraphic ov : graphics) {
                Point2D pos = ov.getBounds(squareSize);            
                Point2D size = new Point2D.Double(squareSize.width,squareSize.height);
                if(         dirPos.getX() < (pos.getX()+size.getX())
                        && dirPos.getX() + dirSize.getX() > pos.getX()
                        &&  dirPos.getY() < (pos.getY()+size.getY())
                        && dirPos.getY()+dirSize.getY() > pos.getY()) {
                    ov.setDirty(true);
                    regions.add(new Rectangle.Double(pos.getX(), pos.getY(),
                    size.getX(), size.getY()));
                }
            }
    } 
    for(LudoGraphic dr : dirty) {
            Point2D dirPos = dr.getLastBounds(squareSize);            
              Point2D dirSize = new Point2D.Double(squareSize.width,squareSize.height);
            
            for(LudoGraphic ov : graphics) {
                Point2D pos = ov.getBounds(squareSize);            
                Point2D size = new Point2D.Double(squareSize.width,squareSize.height);
                if(         dirPos.getX() < (pos.getX()+size.getX())
                        && dirPos.getX() + dirSize.getX() > pos.getX()
                        &&  dirPos.getY() < (pos.getY()+size.getY())
                        && dirPos.getY()+dirSize.getY() > pos.getY()) {
                    ov.setDirty(true);
                    regions.add(new Rectangle.Double(pos.getX(), pos.getY(),
                    size.getX(), size.getY()));
                }
            }
    }
        
          
        return regions;
    }
    
    public void findRedrawAreas(List<LudoGraphic> dirty, List<Rectangle.Double> dirtyRegions) {
        
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
