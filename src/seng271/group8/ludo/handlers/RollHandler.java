/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

import seng271.group8.ludo.GameController;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.MoveEvent;
import seng271.group8.ludo.events.RollEvent;
import seng271.group8.ludo.events.TurnEvent;
import seng271.group8.ludo.model.Move;

/**
 *
 * @author alastair
 */
public class RollHandler extends BaseHandler<RollEvent> {
    
    public RollHandler(GameLogic game) {
        super(game);
    }
    
    @Override
    public void handle(RollEvent evt) {
        System.out.println("Player Rolled, waiting for next roll");      
        Move m = game.getNextMove();
        if(m != null)
           GameController.put(new MoveEvent(m));
        else if (m == null)
           GameController.put(new TurnEvent());    
    }
}
