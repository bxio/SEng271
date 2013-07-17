/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.model;

/**
 *
 * @author Alastairs
 */
public class PathSegment {
    private Square square;
    private PathSegment next;
    
    public PathSegment(Square square) {
        this.square = square;
    }
    
    public void setNext(PathSegment ps) {
        this.next = ps;
    }
    
    public PathSegment getNext() {
        return this.next;
    }
    
    public Square getSquare() {
        return this.square;
    }
}
