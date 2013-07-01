package seng271.group8.ludo.model;

import java.util.ArrayList;

/**
 *
 * @author Alastairs
 * 
 * Generates and instance of the board based
 * on the constants defined in the BoardConfigClass
 */
public class Board {
    
    private Square[] squares;
    
    public Board() {
        
      squares = new Square[BoardConfig.MAP.length];     
      for( int i = 0; i < BoardConfig.MAP.length; i ++) {
          createSquare(BoardConfig.MAP[i], i);
      }
    }
    
    public void createSquare(Grid g, int index) {
        Square s;
        
        switch(g) {
            case P1_HOM:
            case P2_HOM:
            case P3_HOM:
            case P4_HOM:
                s = new Home(g, index);
                break;
            case P1_STA:
            case P2_STA:
            case P3_STA:
            case P4_STA:
                 s = new Entry(g, index);
                break;
            case P1_GOA:
            case P2_GOA:
            case P3_GOA:
            case P4_GOA:
                 s = new Goal(g, index);
                break;
            case EMP_SQ:
            case SQUARE:
            case CENTER:
            case P1_END:
            case P2_END:
            case P3_END:
            case P4_END:
            default:
                s = new Square(g, index);          
        }
        this.squares[index] = s;
    }
    
    public Square[] getSquares() {
        return this.squares;
    }
}
    