/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.actions;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import seng271.group8.ludo.ui.LudoWindow;

/**
 *
 * @author Hiroki
 */
public class CloseAction extends AbstractAction {
    
    LudoWindow game;
    JDialog jd;
    
    public CloseAction(Container game, JDialog toClose) {
        this.game = (LudoWindow)game;
        this.jd = toClose;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Yes")) {
                jd.setVisible(false);
                jd.dispose();
                game.dispatchEvent(new WindowEvent(game, WindowEvent.WINDOW_CLOSING));
            }
            if(e.getActionCommand().equals("No")) {
                jd.setVisible(false);
                jd.dispose();
            }
            if(e.getActionCommand().equals("Quit Game")) {
                jd.setVisible(false);
                jd.dispose();
                game.dispatchEvent(new WindowEvent(game, WindowEvent.WINDOW_CLOSING));
            }
    }
}
