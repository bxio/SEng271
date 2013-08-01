/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import seng271.group8.ludo.strategies.Strategy;
//import seng271.group8.ludo.BufferStrategyDemo;

/**
 *
 * @author Alastairs
 */
public class LudoWindow extends JFrame {
    
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800;
    private static final int SETUP_WIDTH = 600;
    private static final int SETUP_HEIGHT = 400;
    private static final String TITLE = "Group 8 Ludo";
    
    private SetupView setupView = null;
    private GameView gameView = null;
    private JPanel currentView = null;
    
    
    public LudoWindow () {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

        this.setIconImage(new ImageIcon("res/icon.png").getImage());
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setup();
        this.setVisible(true);
    }
    
    private void setup() {
        this.showSetupView();
    }
    
    /**
     * TODO: Alastair Refactor switching views
     */
    public void showSetupView() {
        removeCurrentView();
        this.setSize(SETUP_WIDTH, SETUP_HEIGHT);
        this.setLocationRelativeTo(null);
        
        if(setupView == null)
            setupView = new SetupView(this);
        
        currentView = setupView;
        this.add(currentView);
        this.revalidate();
    }
    
    /**
     * TODO: Alastair Refactor switching views
     */
    public void showGameView(Strategy[] strategies) {
        removeCurrentView();
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocationRelativeTo(null);
        
        if(gameView == null) {
            gameView = new GameView(this, strategies);
            gameView.start();
        }
        
        currentView = gameView;
        this.add(currentView);
        this.revalidate();
    }
    
    /**
     * TODO: Alastair Refactor switching views
     * 
     * I think this will be another panel shown
     * over top of the GameView
     * 
     * TODO: remove
     */
    public void showGameOverView() {
        
    }
    
    public void removeCurrentView() {
       if(currentView != null)
           this.remove(currentView);
    }
   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
               LudoWindow game = new LudoWindow();
            }
        });
    }
}
