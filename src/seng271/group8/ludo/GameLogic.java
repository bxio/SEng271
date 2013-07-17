/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo;

import java.util.ArrayList;
import java.util.List;
import seng271.group8.ludo.events.MoveEvent;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.Path;
import seng271.group8.ludo.model.PathSegment;
import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author alastair
 */
public class GameLogic {
   private Board model;
   private List<Player> players;
   private int turn = 0; // Player 1 always starts
   private int roll;

   public GameLogic(Board b) {
       this.model = b;
       this.players = b.getPlayers();
   }
   
   /*public void setController(GameController gc) {
       this.gc = gc;
   }*/
   
   public void squareClicked(Square s) {
       Player player = getCurrentPlayer();
       Pawn selected = player.getSelectedPawn();
       
       if(selected != null) {
            Move move = this.getValidMove(selected);
            // Player has clicked another players pawn
            if(move.equals(s)) {
                // It is a valid move for the current pawn
                // TODO: Do the move
            }
       } else if(s.getPawn() != null && 
               s.getPawn().getOwner().equals(player)) {
           selected = s.getPawn();
           player.setSelectedPawn(selected);
           this.getValidMove(selected);
           // TODO: Highlight valid move square
       } else {
           player.clearSelectedPawn();
           // TODO: Remove Highlight
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
   
   /***
    * Can be used by the strategies.
    * Will probably move these function into the
    * AbstractStrategy class
    * 
    * @param player
    * @return 
    */
   public List<Move> getValidMoves (Player player) {
       List<Move> moves = new ArrayList<Move>();
    
       
       for(Pawn pw : player.getPawns()) {
           Move m = getValidMove(pw);
       }
       
       return moves;
   }
   
   public Move getValidMove(Pawn pw) {
       return getValidMove(pw, pw.getOwner());
   }
   
   public Move getValidMove(Pawn pw, Player player) {
        Move move = null;
        Path path = player.getPath();
        PathSegment cur;
        int steps = 0;
        cur = path.getSegment(pw.getPosition()).getNext();
        
        while(cur.getNext() != null) {
            /**
             * Logic for determining valid moves!
             * 
             * Is block decides if the pawn can pass or occupy
             * the square.
             */
            if(cur.getSquare().canPass(pw) && steps < roll) {
                continue;
            } else if(roll == steps && 
                    cur.getSquare().canOccupy(pw)) {
               move = new Move(pw, cur.getSquare(), roll);
            } else {
                break;
            }
        }
       
       return move;
   }
   
   public Move getNextMove() {
       advanceTurn();
       return getCurrentPlayer().getMove();
   }
}
