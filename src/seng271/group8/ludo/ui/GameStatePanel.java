/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import seng271.group8.ludo.actions.DiceRollAction;

/**
@@ -14,15 +20,63 @@ import seng271.group8.ludo.actions.DiceRollAction;
 */
public class GameStatePanel extends JPanel{
    private JButton diceRoll;
    private JButton newGame;
    private JButton restart;
    private JButton options;
    private JButton quit;
    private JLabel gameStatus;
    
    public GameStatePanel() {
        this.setup();
    }
    
    public void setup() {
    	
    	this.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	Dimension bSmallSize = new Dimension(80, 30);
    	
    	// Locate "Roll" button onto the center
    	gbc.gridx = 1;
        gbc.gridy = 1;
        
        diceRoll = new JButton("Roll");
        diceRoll.setPreferredSize(new Dimension(80, 60));
        diceRoll.addActionListener(new DiceRollAction());
        this.add(diceRoll);
        this.add(diceRoll, gbc);
        
		// Additional buttons
        gbc.gridx = 0;
        gbc.gridy = 0;     
        newGame = new JButton("New");
        newGame.setPreferredSize(bSmallSize);
        this.add(newGame, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;      
        restart = new JButton("Restart");
        restart.setPreferredSize(bSmallSize);
        this.add(restart, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;    
        options = new JButton("Options");
        options.setPreferredSize(bSmallSize);
        this.add(options, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;   
        quit = new JButton("Quit");
        quit.setPreferredSize(bSmallSize);
        this.add(quit, gbc);

    }
}
