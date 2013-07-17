/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo;

import java.util.ArrayList;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author alastair
 */
public class GameLogic {
   private Board model;
   private ArrayList<Player> players;
   private int turn;

   public GameLogic(Board b) {
       this.model = b;
       this.players = b.getPlayers();
   }
   
   public void squareClicked(Square s) {
   
        if(s.getPawn() != null) {
            if(s.getPawn().getOwner().equals(players.get(turn))) {
                // Player has clicked one of his own pawns
                players.get(turn).setSelectedPawn(s.getPawn());
            } else {
                if(players.get(turn).getSelectedPawn() != null) {
                    ArrayList<Square> moves = this.getValidMoves(s.getPawn());
                    // Player has clicked another players pawn
                    if(moves.contains(s)) {
                        // It is a valid move for the current pawn
                        // Do the move
                    }
                }
            }
        } else {
            // could still be a valid move
        } 
               
   }
   
   public Player getCurrentPlayer() {
       return players.get(turn);
   }
   
   public void makeMakeMove(Move m) {
       
   }
   
   public void moveFinished() {
       advanceTurn();
       players.get(turn).getMove();
   }
   
   public void advanceTurn() {
       turn = (turn + 1) % players.size();
   }
   
   public void setModel(Board b) {
    model = b;
   }
   
   public ArrayList<Square> getValidMoves(Pawn p) {
       return null;
   }
   
   public  Player getTurn () {
       return null;
   }
}
