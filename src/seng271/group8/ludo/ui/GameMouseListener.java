/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.actions.BoardClickEvent;
import seng271.group8.ludo.graphics.Renderer2D;

/**
 *
 * @author Alastairs
 */
public class GameMouseListener implements MouseListener {
    
    private GamePanel game;
    private Renderer2D playArea;
    private GameController gc;
    
    public GameMouseListener(GamePanel game, GameController gc){
        this.game = game;
        this.gc = gc;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       System.out.println(game.getRenderer2D().graphicToGridCoords(e.getX(), e.getY()).x);
      
       
       
       BoardClickEvent bc = new BoardClickEvent(e);         
       gc.put(bc);
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
