/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alastairs
 */
public class Path extends LinkedList<PathSegment> {
    
    private List<Square> homeSquares;
    
    public Path(List<Square> startSquares) {
        this.homeSquares = startSquares;
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
    
    public Square getHomeSquare(Pawn pw) {
        Square home = null;
        
        for(Square s : homeSquares) {
                if(pw.getPosition().equals(s)) {
                    home = s; break;
                }
 
        }
        return home;
    }
    
    public List<Square> getHomeSquares() {
        return this.homeSquares;
    }
}
