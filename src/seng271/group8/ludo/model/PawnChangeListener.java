/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import seng271.group8.ludo.events.TurnEvent;
import seng271.group8.ludo.graphics.Animator;
import seng271.group8.ludo.graphics.IAnimatable;
import seng271.group8.ludo.graphics.MoveBuilder;
import seng271.group8.ludo.graphics.PulseBuilder;

/**
 *
 * @author Alastairs
 */
public class PawnChangeListener implements PropertyChangeListener {
    
    MoveBuilder moveBuilder;
    PulseBuilder pulseBuilder;
    Animator animator;
    
    public PawnChangeListener(Animator animator, MoveBuilder builder, PulseBuilder p) {
        this.animator = animator;
        this.moveBuilder = builder;
        this.pulseBuilder = p;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        IAnimatable ani = null;
        if(Pawn.MOVE.equals(propertyName)) {
            ani = moveBuilder.build((Pawn)evt.getSource());               
        } else if (Pawn.SELECTED.equals(propertyName)) {
            //ani = pulseBuilder.build((GameEntity)evt.getSource());
        }
         if(ani != null)
                animator.addAnimation(ani, new TurnEvent());
         
    }
    
}
