package seng271.group8.ludo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.BoardClickEvent;
import seng271.group8.ludo.events.MoveEvent;
import seng271.group8.ludo.handlers.BoardClickHandler;
import seng271.group8.ludo.handlers.MoveHandler;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Player;

/**
 *
 * @author Alastairs
 */
public class GameView extends JPanel {
    
    private GamePanel playArea;
    private GameStatePanel gameState;
    
    private GameController gameController;
    private GameLogic gamelogic;
    private Board board;
    
    private Thread controllerThread;
    
    public GameView() {
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
    }
    
    public void start() {
        
        // Create the game model
        board = new Board();
        
        gamelogic = new GameLogic(board);
        
        // Temp for now
        ArrayList<Player> players = board.getPlayers();
        
        // Wire events
        gameController = new GameController();
        gameController.register(BoardClickEvent.class, new BoardClickHandler(players, board, gamelogic));
        gameController.register(MoveEvent.class, new MoveHandler(gamelogic));
        
        // Start GameEvents thread
        controllerThread = new Thread(gameController);
        controllerThread.setDaemon(true);
        controllerThread.start();
        
        // Create the game area
        playArea = new GamePanel(board, gameController);
        this.add(playArea);
    }
}
