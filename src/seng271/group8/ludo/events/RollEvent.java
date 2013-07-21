/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.events;

/**
 *
 * @author alastair
 */
public class RollEvent extends GameEvent {
    private Boolean deferredRoll = false;
    
    public RollEvent() {
        
    }
    
    public RollEvent(Boolean deferred) {
        this.deferredRoll = deferred;
    }
    
    public Boolean isDeferred() {
        return this.deferredRoll;
    }
}
