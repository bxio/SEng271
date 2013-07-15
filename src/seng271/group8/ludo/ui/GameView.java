package seng271.group8.ludo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.model.Board;

/**
 *
 * @author Alastairs
 */
public class GameView extends JPanel {
    
    private GamePanel playArea;
    private GameStatePanel gameState;
    private GameController gc;
    private Thread controller;
    
    public GameView() {
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
    }
    
    public void start() {
        gc = new GameController();
        controller = new Thread(gc);
        controller.start();
        playArea = new GamePanel(new Board(), gc);
        this.add(playArea);
    }
}
