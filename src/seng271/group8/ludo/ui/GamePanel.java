/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Graphics;
import javax.swing.JPanel;
import seng271.group8.ludo.graphics.Animator;
import seng271.group8.ludo.graphics.Renderer2D;
import seng271.group8.ludo.model.Board;

/**
 *
 * @author Alastairs
 */
public class GamePanel extends JPanel {
    
    private Board board;
    private Renderer2D renderer;
    private Animator animationThread;
    
    public GamePanel(Board b) {
        this.board = b;
        this.renderer = new Renderer2D(this);
        this.animationThread = new Animator(this);
        // make sure the thread stops when the JFrame is closed
        this.animationThread.setDaemon(true);
        this.animationThread.start();
        this.addMouseListener(new GameMouseListener(this));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       renderer.paint(g);
    }
    
    public Renderer2D getRenderer2D() {
        return this.renderer;
    }
    
    public Board getBoard() {
        return this.board;
    }
}
