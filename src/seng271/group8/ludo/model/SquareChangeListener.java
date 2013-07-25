/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.beans.PropertyChangeEvent;
import java.util.Map;
import seng271.group8.ludo.events.GameEvent;
import seng271.group8.ludo.events.KickPawnEvent;
import seng271.group8.ludo.events.TurnEvent;
import seng271.group8.ludo.graphics.AnimationBuilder;
import seng271.group8.ludo.graphics.Animator;
import seng271.group8.ludo.graphics.IAnimatable;
import seng271.group8.ludo.graphics.MoveBuilder;
import seng271.group8.ludo.graphics.PulseBuilder;

/**
 *
 * @author alastair
 */
public class SquareChangeListener extends AbstractChangeListener {
    
    public SquareChangeListener(Animator animator, 
            Map<Class<? extends AnimationBuilder>,AnimationBuilder> builders) {
        super(animator, builders);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        IAnimatable ani = null;
        GameEvent ge = null;

        if (Square.SELECTED.equals(propertyName)) {
            ani = builders.get(PulseBuilder.class).build((Square)evt.getSource(),0,0);
        }
         if(ani != null && ge != null)
            animator.addAnimation(ani, ge);
         else if(ani != null)
            animator.addAnimation(ani); 
    }
}

