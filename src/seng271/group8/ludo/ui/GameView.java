package seng271.group8.ludo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import seng271.group8.ludo.Die;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.BoardClickEvent;
import seng271.group8.ludo.events.KickPawnEvent;
import seng271.group8.ludo.events.MoveEvent;
import seng271.group8.ludo.events.RollEvent;
import seng271.group8.ludo.events.TurnEvent;
import seng271.group8.ludo.graphics.DieGraphic;
import seng271.group8.ludo.graphics.Renderer2D;
import seng271.group8.ludo.handlers.BoardClickHandler;
import seng271.group8.ludo.handlers.KickPawnEventHandler;
import seng271.group8.ludo.handlers.MoveHandler;
import seng271.group8.ludo.handlers.RollHandler;
import seng271.group8.ludo.handlers.TurnEventHandler;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.DieChangeListener;
import seng271.group8.ludo.model.Player;
import seng271.group8.ludo.strategies.HumanStrategy;
import seng271.group8.ludo.strategies.Strategy;

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
    private Die die;
    
    private Thread controllerThread;
    
    public GameView(Strategy[] strategies) {
        //this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
       
        // Create the game model
        board = new Board(strategies);
        die = new Die();
        //d.addPropertyChangeListener(new DieChangeListener())
        //d.setRendering(new DieGraphic(board.getCentrePoint()));
        gamelogic = new GameLogic(board, die);
    }
    
    public void start() {
        
          // Temp for now
        List<Player> players = board.getPlayers();
        List<Player> humans = new ArrayList<Player>();
        
        for(Player p : players) {
            if(p.getStrategy().getClass().equals(HumanStrategy.class))
                humans.add(p);
        }
        
        // Wire events
        gameController = new GameController();
        GameController.register(BoardClickEvent.class, new BoardClickHandler(humans, board, gamelogic));
        GameController.register(MoveEvent.class, new MoveHandler(gamelogic));
        GameController.register(KickPawnEvent.class, new KickPawnEventHandler(gamelogic));
        GameController.register(TurnEvent.class, new TurnEventHandler(gamelogic));
        GameController.register(RollEvent.class, new RollHandler(gamelogic));
        
        // Start GameEvents thread
        controllerThread = new Thread(gameController);
        controllerThread.setName("GameEvent Dispatcher");
        controllerThread.setDaemon(true);
        controllerThread.start();
        
        // Create the game area
        playArea = new GamePanel(board, die);
        this.add(playArea);
        
        // Create game state
        this.add(new GameStatePanel(), BorderLayout.SOUTH);
        
        // Start the game (after 5 seconds)
        GameController.publish(new TurnEvent(5000));
    }
}
