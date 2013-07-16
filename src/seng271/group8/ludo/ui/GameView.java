package seng271.group8.ludo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.actions.BoardClickEvent;
import seng271.group8.ludo.actions.BoardClickHandler;
import seng271.group8.ludo.model.Board;

/**
 *
 * @author Alastairs
 */
public class GameView extends JPanel {
    
    private GamePanel playArea;
    private GameStatePanel gameState;
    private GameController gameController;
    private GameLogic gamelogic;
    private Thread controllerThread;
    
    public GameView() {
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
    }
    
    public void start() {
        
        Board board = new Board();
        gameController = new GameController();
        gameController.register(BoardClickEvent.class, new BoardClickHandler(board));     
        
        controllerThread = new Thread(gameController);
        controllerThread.setDaemon(true);
        controllerThread.start();
        playArea = new GamePanel(board, gameController);
        this.add(playArea);
    }
}
