/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Grid;

/**
 *
 * @author Alastairs
 */
public class GameMouseListener implements MouseListener {
    
    private GamePanel game;
    
    public GameMouseListener(GamePanel game){
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(game.getRenderer2D().graphicToGridCoords(e.getX(), e.getY()).x);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
