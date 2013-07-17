/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

import seng271.group8.ludo.GameController;
import seng271.group8.ludo.events.MoveEvent;
import seng271.group8.ludo.events.TurnEvent;
import seng271.group8.ludo.model.Move;

/**
 *
 * @author alastair
 */
public class TurnEventHandler extends BaseHandler<TurnEvent> {

    @Override
    public void handle(TurnEvent evt) {
       Move m = game.getNextMove();
        if(m != null)
           GameController.put(new MoveEvent(m));
    }
    
}
