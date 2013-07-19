/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;
import seng271.group8.ludo.graphics.Animator;
import seng271.group8.ludo.graphics.MoveBuilder;
import seng271.group8.ludo.graphics.PawnGraphic;
import seng271.group8.ludo.graphics.Renderer2D;
import seng271.group8.ludo.graphics.SquareGraphic;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.PawnChangeListener;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class GamePanel extends JComponent implements ComponentListener {
    
    private Board board;
    private Renderer2D renderer;
    private Animator animationThread;
    
    public GamePanel(Board b) {
        this.setOpaque(true);
        this.board = b;
        this.renderer = new Renderer2D();
        
        
        this.animationThread = new Animator(this);
        // make sure the thread stops when the JFrame is closed
        this.animationThread.setDaemon(true);
        this.animationThread.start();
        
        for(Square s : board.getSquareList()) {
            s.setRendering(new SquareGraphic(s));
            renderer.add(s.getRendering());
        }

        MoveBuilder mb = new MoveBuilder();
        
        for(Pawn pw : board.getPawnList()) {
            pw.setRendering(new PawnGraphic(pw));
            renderer.add(pw.getRendering());
            pw.addPropertyChangeListener(new PawnChangeListener(
                    animationThread,mb));
        }
        
        this.addMouseListener(new GameMouseListener(this));
        this.addComponentListener(this);
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       //super.paintComponent(g);
       
       //System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
       //long start = System.currentTimeMillis();
       
       renderer.paint(g);
       //System.out.println(System.currentTimeMillis()-start);
    }
    
    public Renderer2D getRenderer2D() {
        return this.renderer;
    }
    
    public Board getBoard() {
        return this.board;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        renderer.resize(this.getSize());
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
