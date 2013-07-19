/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.graphics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alastair
 */
public class Animation2DGroup implements IAnimatable {
    
    private List<IAnimatable> group;
    
    public Animation2DGroup() {
        this.group = new ArrayList<IAnimatable>();
    }
    
    public void add(IAnimatable i) {
        this.group.add(i);
    }

    @Override
    public Boolean tic(long dt) {
        Boolean done = true;
        for(IAnimatable i : group) {
            done = done && i.tic(dt);
        }
        return done;
    }

    @Override
    public void start() {
        for(IAnimatable i : group)
            i.start();
    }

    /*@Override
    public void onComplete(Action done) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
