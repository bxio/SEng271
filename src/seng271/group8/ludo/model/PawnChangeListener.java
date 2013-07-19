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

/**
 *
 * @author Alastairs
 */
public class PawnChangeListener implements PropertyChangeListener {
    
    MoveBuilder builder;
    Animator animator;
    
    public PawnChangeListener(Animator animator, MoveBuilder builder) {
        this.animator = animator;
        this.builder = builder;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if(Pawn.MOVE.equals(propertyName)) {
            IAnimatable ani = builder.build((Pawn)evt.getSource());
            if( ani != null)
                animator.addAnimation(ani, new TurnEvent());
                
        } else if (Pawn.SELECTED.equals(propertyName)) {
            
        }
    }
    
}
