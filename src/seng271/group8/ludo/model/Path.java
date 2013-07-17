/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.util.LinkedList;

/**
 *
 * @author Alastairs
 */
public class Path extends LinkedList<PathSegment> {
    public Path() {
        
    }
    
    public PathSegment getSegment(Square s) {
        PathSegment found = null;
        
        for(PathSegment ps : this) {
           if(ps.getSquare().equals(s)) {
               found = ps;
               break;
           }
        }
        
        return found;
    }
}
