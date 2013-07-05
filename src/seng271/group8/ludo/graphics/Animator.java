/* 
* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

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
    
    public Animator(GamePanel game) {
        super();
        this.game = game;
        this.renderer = game.getRenderer2D();
    }
    
    @Override
    public void run() {
       
        while(isRunning) {

            long start = System.currentTimeMillis();
            long dt;
            dt = lastFrame == 0 ? 0 : start - lastFrame;
            lastFrame = start;
            long wait = 10;

            renderer.refresh(dt);

            // Calculate how long to wait for the next frame
            wait = FRAME_PERIOD - (System.currentTimeMillis() - start);
    
//            System.out.println("Wait was:" + wait);
            
            if(wait > 0) {
               try {
                    Thread.sleep(wait);
               } catch (InterruptedException e) {}
            }
        }
    }
}
