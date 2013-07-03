package seng271.group8.ludo.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 * 
 * Generates and instance of the board based
 * on the constants defined in the BoardConfigClass
 */
public class Board {
    
    private Square[][] squares;
    private ArrayList<Square> squareList;
    private ArrayList<LinkedList<Square>> paths;
    
    public Board() {
        
        squareList = new ArrayList<Square>();
        squares = new Square[BoardConfig.WIDTH][BoardConfig.HEIGHT];
        for( int i = 0; i < BoardConfig.HEIGHT; i ++) {
            for( int j = 0; j < BoardConfig.WIDTH; j++){
                // row*column loop (j,i) opposite to what might be expected
                // System.out.println("I: " + i + " J: " + j);
                createSquare(BoardConfig.MAP[i][j], new Point(j,i));
            }
        }
    
        buildPaths();
    }
    
    public void createSquare(Grid g, Point position) {
        Square s;
        
        switch(g) {
            case P1_HOM:
            case P2_HOM:
            case P3_HOM:
            case P4_HOM:
                s = new Home(g, position);
                break;
            case P1_STA:
            case P2_STA:
            case P3_STA:
            case P4_STA:
                 s = new Entry(g, position);
                break;
            case P1_GOA:
            case P2_GOA:
            case P3_GOA:
            case P4_GOA:
                 s = new Goal(g, position);
                break;
            case EMP_SQ:
            case SQUARE:
            case CENTER:
            case P1_END:
            case P2_END:
            case P3_END:
            case P4_END:
            default:
                s = new Square(g, position);          
        }
        this.squareList.add(s);
        this.squares[position.x][position.y] = s;
    }
    
    public void buildPaths() {
        this.paths = new ArrayList<LinkedList<Square>>();
        
        for(int i = 0; i < BoardConfig.START_SQUARES.length; i++) {
            LinkedList<Square> path = new LinkedList<Square>();
            this.paths.add(path);
            path.add(getSquareAt(BoardConfig.START_SQUARES[i].x, BoardConfig.START_SQUARES[i].y));
            Point[] pathVectors = this.rotatePath(BoardConfig.PATH, BoardConfig.ROTATION_OFFSET*i);
            for(int j = 0; j < pathVectors.length; j++) {
                    addToPath(path, pathVectors[j]);
            }
            
        }
    }
    
    /****
     * Walks a path from a starting point given a list of vectors
     * Adds these vectors to the specified path
     * 
     * @param path
     * @param vector 
     */
    public void addToPath(LinkedList<Square> path, Point vector) {
        int xMag = vector.x;
        int yMag = vector.y;
        int xInc = 0;
        int yInc = 0;
        
        if(xMag != 0)
            xInc = xMag/Math.abs(xMag);
        if(yMag != 0)
            yInc = -yMag/Math.abs(yMag);
 
        Square last = path.getLast();
       
        while(yMag != 0 || xMag != 0) {
            
            Square s = this.getSquareAt(last.getPosition().x + xInc, last.getPosition().y + yInc);
           //System.out.println("x:" + (last.getPosition().x + xInc) +" y:" + (last.getPosition().y + yInc));
            yMag += yInc;
            xMag -= xInc;
      
            if(s != null) {
               path.add(s);
               last = s;
            }
            else {
                // TODO: Throw invalid path exception
                break;
            }
        }
    }
    
    public Point[] rotatePath(Point[] path,double rads) {
        Point[] rPath = new Point[path.length];
        int x,y;
        //System.out.println(rads);
        for(int i = 0; i < path.length; i++) {
            x = path[i].x*(int)Math.cos(rads) - path[i].y*(int)Math.sin(rads);
            y = path[i].x*(int)Math.sin(rads) + path[i].y*(int)Math.cos(rads);
            //System.out.println("Old: (" + path[i].x + "," + path[i].y + ") New: (" + x + "," +  y +")");
            rPath[i] = new Point(x,y);
        }
        
        return rPath;
    }
    
    public Square getSquareAt(int row, int column) {
        Square s = null;
        try{
            s = this.squares[row][column];
        } catch (Exception e) {
            
        }
        return s;
    }
    
    public ArrayList<Square> getSquareList() {
        return this.squareList;
    }
    
    public ArrayList<LinkedList<Square>> getPaths() {
        return this.paths;
    }
   
}
    