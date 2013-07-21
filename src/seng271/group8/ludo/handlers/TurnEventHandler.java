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
public class TurnEventHandler extends BaseHandler<TurnEvent> {
    
    public TurnEventHandler(GameLogic game) {
        super(game);
    }
    
    @Override
    public void handle(TurnEvent evt) {
        System.out.println("It is now the next players turn");
        int roll = game.getRoll(); 
        System.out.println("They rolled " + roll);
        if(roll != -1) {
            Move m = game.getNextMove();
            if(m != null)
                GameController.put(new MoveEvent(m));
            else if (m == null)
                 GameController.put(new TurnEvent());  
        }
    }
}
