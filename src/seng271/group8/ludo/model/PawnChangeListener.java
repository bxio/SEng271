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
 * @author Alastairs
 */
public class PawnChangeListener extends AbstractChangeListener {
    
    public PawnChangeListener(Animator animator, 
            Map<Class<? extends AnimationBuilder>,AnimationBuilder> builders) {
        super(animator, builders);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        IAnimatable ani = null;
        GameEvent ge = null;
        if(Pawn.MOVE.equals(propertyName)) {
            Pawn p = (Pawn)evt.getSource();
            ani = builders.get(MoveBuilder.class).build(p);
            if(p.getMove().doesKick())
                ge = new KickPawnEvent(p.getMove().getKickMove());
            else
                ge = new TurnEvent();
        } else if (Pawn.SELECTED.equals(propertyName)) {
            ani = builders.get(PulseBuilder.class).build((GameEntity)evt.getSource());
        }
         if(ani != null && ge != null)
            animator.addAnimation(ani, ge);
         else if(ani != null)
            animator.addAnimation(ani); 
    }
    
}
