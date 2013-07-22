/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.events;

import seng271.group8.ludo.model.Move;

/**
 *
 * @author alastair
 */
public class KickPawnEvent extends GameEvent {
 
    private Move kick;
    
    public KickPawnEvent(Move kick) {
        this.kick = kick;
    }
    
    public Move getKickMove() {
        return this.kick;
    }
}
