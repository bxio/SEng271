/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import seng271.group8.ludo.graphics.TranslateAnimation;
import seng271.group8.ludo.model.Pawn;

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
        ArrayList<Pawn> pw = game.getBoard().getPawnList();
       // game.getRenderer2D().addAnimation(new TranslateAnimation(pw.get(0), new Point(e.getX(),e.getY()), 2000));
                
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
