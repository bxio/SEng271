/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alastairs
 */
public class LudoWindow extends JFrame {
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final String TITLE = "Group 8 Ludo";
    
    private SetupView setupView = null;
    private GameView gameView = null;
    private JPanel currentView = null;
    
    
    public LudoWindow () {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(TITLE);
        this.setLocationRelativeTo(null);
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
        
        if(setupView == null)
            setupView = new SetupView(this);
            
        currentView = setupView;
        this.add(currentView);
        this.revalidate();
    }
    
    /**
     * TODO: Alastair Refactor switching views
     */
    public void showGameView() {
        removeCurrentView();
        
        if(gameView == null)
            gameView = new GameView(); 
        
        currentView = gameView;
        this.add(currentView);
        this.revalidate();
    }
    
    /**
     * TODO: Alastair Refactor switching views
     */
    public void showGameOverView() {
        
    }
    
    public void removeCurrentView() {
       if(currentView != null)
           this.remove(currentView);
    }
   
    public static void main(String[] args) {
        LudoWindow game = new LudoWindow();
    }
}
