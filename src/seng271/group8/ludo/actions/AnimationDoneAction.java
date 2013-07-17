/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.actions;

import seng271.group8.ludo.GameController;
import seng271.group8.ludo.events.MoveFinishedEvent;

/**
 *
 * @author Alastairs
 */
public class AnimationDoneAction {
    public AnimationDoneAction(GameController gc) {
        gc.put(new MoveFinishedEvent());
    }
}
