/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import seng271.group8.ludo.actions.StartGameAction;
import seng271.group8.ludo.strategies.AggressiveStrategy;
import seng271.group8.ludo.strategies.BrutalStrategy;
import seng271.group8.ludo.strategies.CautiousStrategy;
import seng271.group8.ludo.strategies.DefensiveStrategy;
import seng271.group8.ludo.strategies.HumanStrategy;
import seng271.group8.ludo.strategies.MoveFirstStrategy;
import seng271.group8.ludo.strategies.MoveLastStrategy;
import seng271.group8.ludo.strategies.Strategy;

/**
 *
 * @author Alastairs
 */
public class SetupView extends JPanel {
    
    private PlayerSelectPanel[] players = new PlayerSelectPanel[4];
    JButton playNow;
    private LudoWindow ludo;
 
    public SetupView(LudoWindow ludo) {
        
        Strategy[] strategies = {
            new AggressiveStrategy(),
			//new CautiousStrategy(),
			//new DefensiveStrategy(),
            new HumanStrategy(),
            new MoveFirstStrategy(),
            new MoveLastStrategy(),
			//new BrutalStrategy(),
			//new RandomStrategy(),
        };
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.ludo = ludo;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = gbc.weighty = 1.0;
        players[0] = new PlayerSelectPanel("Player 1", strategies);
        this.add(players[0], gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        players[1] = new PlayerSelectPanel("Player 2", strategies);
        this.add(players[1], gbc); 
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth =1;
        players[2] = new PlayerSelectPanel("Player 3", strategies);
        this.add(players[2], gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        players[3] = new PlayerSelectPanel("Player 4", strategies);
        this.add(players[3], gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        playNow = new JButton("Play Now!");
        this.add(playNow, gbc);
        
        playNow.addActionListener(new StartGameAction(ludo, players));

    }
}
