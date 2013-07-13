/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Graphics;
import javax.swing.JComponent;
import seng271.group8.ludo.graphics.Animator;
import seng271.group8.ludo.graphics.Renderer2D;
import seng271.group8.ludo.model.Board;

/**
 *
 * @author Alastairs
 */
public class GamePanel extends JComponent {
    
    private Board board;
    private Renderer2D renderer;
    private Animator animationThread;
    
    public GamePanel(Board b) {
        this.board = b;
        this.setOpaque(true);
        this.renderer = new Renderer2D(this);
        this.animationThread = new Animator(this);
        // make sure the thread stops when the JFrame is closed
        this.animationThread.setDaemon(true);
        this.animationThread.start();
        this.addMouseListener(new GameMouseListener(this));
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
}
