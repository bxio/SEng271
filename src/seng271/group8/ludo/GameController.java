/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import seng271.group8.ludo.actions.GameEvent;
import seng271.group8.ludo.actions.Handler;
import seng271.group8.ludo.model.*;

/**
 *
 * @author Alastairs
 * 
 * Might rename this to notification center or something closer to what 
 * it actually does.
 * 
 * I don't have any experience coding something like this, let me know if it 
 * seems nuts.
 */
public class GameController implements Runnable {
    
    BlockingQueue<GameEvent> gameEvents = new LinkedBlockingQueue<GameEvent>();
    private Boolean isRunning = true;
    
    private final HashMap<Class<? extends GameEvent>,ArrayList<Handler>> map = 
            new HashMap<Class<? extends GameEvent>,ArrayList<Handler>>();
    
    private LinkedList<Move> history;
    
    public GameController() {
        
    }

    @Override
    public void run() {
       while(isRunning) {
           try {
               GameEvent ge = gameEvents.take();
               synchronized(map) {dispatch(ge);}
           } catch (InterruptedException ex) {
               Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    public synchronized <T extends GameEvent> void register(Class<T> evtClass, Handler<T> h) {
        ArrayList<Handler> handlers = map.get(evtClass);
        if(handlers == null) {
            handlers = new ArrayList<Handler>();
            map.put(evtClass, handlers);
        }
        handlers.add(h);
    }
    
    private void dispatch(GameEvent event) {
        ArrayList<Handler> handlers = map.get(event.getClass());
        if(handlers != null)
            for(Handler hd : handlers) {
                hd.handle(event);
            }
        else
            System.out.println("No handlers registered for event"  + event.getClass());
    }
    
    public void put(GameEvent e) {
        try {
            this.gameEvents.put(e);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
