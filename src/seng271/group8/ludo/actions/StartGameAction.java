/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.actions;

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import seng271.group8.ludo.ui.LudoWindow;

/**
 *
 * @author Alastairs
 */
public class StartGameAction extends AbstractAction {
    LudoWindow game;
    
    public StartGameAction(Container game) {
        this.game = (LudoWindow)game;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.game.showGameView();
    }
    
}
