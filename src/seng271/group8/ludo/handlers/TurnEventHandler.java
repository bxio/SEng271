/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

import seng271.group8.ludo.GameController;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.GameOverEvent;
import seng271.group8.ludo.events.RollEvent;
import seng271.group8.ludo.events.TurnEvent;

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
        if(game.checkForWin()) {
            GameController.publish(new GameOverEvent());
            return;
        }
        
        if(game.getRoll() != 6)
           game.advanceTurn();
        game.setRoll(-1);
        int roll = game.makeRoll(); 
        System.out.println("Player " + game.getCurrentPlayer().getId() + " rolled: " + roll);
        if(roll != -1) {
            GameController.publish(new RollEvent(roll,1000));
        }
    }
}
