/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import seng271.group8.ludo.model.Board;

/**
 *
 * @author Alastairs
 */
public class GameView extends JPanel {
    
    private GamePanel playArea;
    private GameStatePanel gameState;
    
    public GameView() {
        playArea = new GamePanel(new Board());
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
        this.add(playArea);
        this.setVisible(true);
    }
}
