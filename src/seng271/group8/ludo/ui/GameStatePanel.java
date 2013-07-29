/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import seng271.group8.ludo.GameLogic;

import seng271.group8.ludo.actions.DiceRollAction;
import seng271.group8.ludo.actions.QuitGameAction;
import seng271.group8.ludo.actions.OptionsAction;
import seng271.group8.ludo.actions.RestartGameAction;

/**
 *
 * @author Hiroki
 */
public class GameStatePanel extends JPanel{
    
    private JButton diceRoll;
    private JButton newGame;
    private JButton restart;
    private JButton options;
    private JButton quit;
    private GameLogic game;
    
    public GameStatePanel(GameLogic game) {
        this.game = game;
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
        diceRoll.addActionListener(new DiceRollAction(game));
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
        restart.addActionListener(new RestartGameAction());
        
        gbc.gridx = 0;
        gbc.gridy = 2;    
        options = new JButton("Options");
        options.setPreferredSize(bSmallSize);
        this.add(options, gbc);
        options.addActionListener(new OptionsAction());
        
        gbc.gridx = 2;
        gbc.gridy = 2;   
        quit = new JButton("Quit");
        quit.setPreferredSize(bSmallSize);
        this.add(quit, gbc);
        quit.addActionListener(new QuitGameAction());

    }

}
