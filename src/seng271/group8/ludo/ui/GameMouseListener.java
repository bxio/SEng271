/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.events.BoardClickEvent;
import seng271.group8.ludo.graphics.Renderer2D;

/**
 *
 * @author Alastairs
 */
public class GameMouseListener implements MouseListener {
    
    private GamePanel game;
    private Renderer2D playArea;
    private GameController gc;
    
    public GameMouseListener(GamePanel game){
        this.game = game;
        this.gc = gc;
        this.playArea = game.getRenderer2D();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Am I missing clicks?");
        Point p = playArea.graphicToGridCoords(e.getX(), e.getY());
        BoardClickEvent bc = new BoardClickEvent(p);         
        GameController.put(bc);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
