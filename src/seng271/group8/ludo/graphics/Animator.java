/* 
* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.events.GameEvent;
import seng271.group8.ludo.ui.GamePanel;

/**
 *
 * @author Alastairs
 */
public class Animator extends Thread {
    
    private GamePanel game;
    private Renderer2D renderer;

    private boolean isRunning = true;
    private long lastFrame = 0;
    private final static int TARGET_FPS = 60;
    private final static int FRAME_PERIOD = 1000/TARGET_FPS; // 1000 ms
    private static final int FRAMES = 24;

    private Map<IAnimatable, GameEvent> events;
    private List<IAnimatable> newAnimations;
    private List<IAnimatable> active;
    
    public Animator(GamePanel game) {
        super();
        this.game = game;
        this.active = new ArrayList<IAnimatable>();
        this.newAnimations = new ArrayList<IAnimatable>();
        this.events = new HashMap<IAnimatable, GameEvent>();
        this.setName("Animation Thread");
    }
    
    public void refresh(long dt) {
        
        List<IAnimatable> finished = new ArrayList<IAnimatable>();
        
        Iterator<IAnimatable> iter = newAnimations.iterator();
        while (iter.hasNext()) {
            IAnimatable a = iter.next();
                active.add(a);
                a.start();
                iter.remove();
        }
        
        for(IAnimatable a : active) {
            if(a.tic(dt))
                finished.add(a);
        }
        
        for(IAnimatable a : finished) {
            active.remove(a);
            if(events.containsKey(a)) {
                GameController.put(events.remove(a));
            }
        }
        
        //if(!active.isEmpty())
            game.repaint();
    }
    
    public void addAnimation(IAnimatable animation) {
        this.newAnimations.add(animation);
    }
    
    /*
     * Raise some GameEvent when the animation completes
     */
    public void addAnimation(IAnimatable animation, GameEvent event) {
        this.addAnimation(animation);
        this.events.put(animation, event);
    }
    
    @Override
    public void run() {
       
        while(isRunning) {

            long start = System.currentTimeMillis();
            long dt;
            dt = lastFrame == 0 ? 0 : start - lastFrame;
            lastFrame = start;
            long wait;
        
            refresh(dt);
            
            // Calculate how long to wait for the next frame
            wait = FRAME_PERIOD - (System.currentTimeMillis() - start);
            
            //System.out.println("Wait was:" + wait);
            if(wait > 0) {
               try {
                    Thread.sleep(wait);
               } catch (InterruptedException e) {}
            }
        }
    }
}
