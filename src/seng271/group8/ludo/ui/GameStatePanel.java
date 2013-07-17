/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alastairs
 */
public class GameStatePanel extends JPanel{
    private JButton diceRoll;
    
    public GameStatePanel() {
        this.setup();
    }
    
    public void setup() {
        
        diceRoll = new JButton("Roll");
        this.add(diceRoll);
    }
}
