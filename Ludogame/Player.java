/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bill
 */
public class Player {
    private String colour;
    private Pawn home[];
    //private int strategy;//between 1 to 5.
/*
 (1)Aggressive: Give preference to a move that kicks a pawn;
 (2)Cautious: Give low priority to a move that kicks a pawn (so as not to anger the other
player);
 (3)Defensive: Give preference to a move to a target field where the pawn cannot be kicked;
 (4)Move-first: Give preference to moving the foremost pawn;
 (5)Move-last: Give preference to moving the hindmost pawn.
 */
    public void setColour(String colour){
        this.colour = colour;
    }
    public void init(String colour, int option){
        this.colour = colour;
    }
    public void planMove(int roll){
        
    }
    
    public void executeMove(){
        
    }
}
