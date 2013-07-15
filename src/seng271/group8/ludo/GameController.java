/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo;

import javax.swing.AbstractAction;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import seng271.group8.ludo.actions.GameEvent;
import seng271.group8.ludo.model.*;

/**
 *
 * @author Alastairs
 */
public class GameController implements Runnable {
    
    BlockingQueue<GameEvent> gameEvents = new LinkedBlockingQueue<GameEvent>();
    private Boolean isRunning = true;
    
    private LinkedList<Move> history;
    
    public GameController() {
        
    }

    @Override
    public void run() {
       while(isRunning) {
           try {
               GameEvent ge = gameEvents.take();
               System.out.println("Took some event off the queue");
               ge.run();
           } catch (InterruptedException ex) {
               Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    public void put(GameEvent e) {
        try {
            this.gameEvents.put(e);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
