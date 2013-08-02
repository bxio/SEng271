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
    

    //Gets the pawn's home square if it's sitting on it (null otherwise)
    public Square getHomeSquare(Pawn pw) {
        Square home = null;

        for(Square s : homeSquares) {
			if(pw.getSquare().equals(s)) {
				home = s; break;
			}
        }
        return home;
    }
    
    public List<Square> getHomeSquares() {
        return this.homeSquares;
    }
	
	public List<PathSegment> getCollectionOfPreviousSquares(int numSquares, Square last) {
		int lastPos = this.indexOf(last);
		if(numSquares > lastPos){
			return null;
		}
		List<PathSegment> list = new LinkedList<PathSegment>();
		
		for(int i=lastPos; i>=lastPos-numSquares; i--){
			list.add(this.get(i));
		}
		List<PathSegment> ret = new LinkedList<PathSegment>();
		
		for(PathSegment s: list){//reverse the list
			ret.add(list.get(list.size()-1));
			list.remove(list.size()-1);
		}
		return ret;
	}
	
	public PathSegment getPreviousPathSegment(int numBefore, Square last) {
		int lastPos = this.indexOf(last);
		if(numBefore > lastPos){
			return null;
		}else{
			return this.get(lastPos-numBefore);
		}
	}
	
}
