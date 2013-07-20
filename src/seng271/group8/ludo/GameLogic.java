/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo;

import java.util.LinkedList;
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
   private int roll = 6; // Hardcoded for testing

   public GameLogic(Board b) {
       this.model = b;
       this.players = b.getPlayers();
   }
   
   /*public void setController(GameController gc) {
       this.gc = gc;
   }*/
   
   public void squareClicked(Square s) {
       Move move;
       Player player = getCurrentPlayer();
       Pawn selected = player.getSelectedPawn();
       
       if(selected != null) {
            move = this.getValidMove(selected);
            // Player has clicked another players pawn
            if(move != null) {
                if(move.getSquares().getLast().equals(s)) {
                    GameController.put(new MoveEvent(move));     
                    move.getSquares().getLast().setSelected(Boolean.FALSE);
                }
                move.getSquares().getLast().setSelected(true);
                selected.setSelected(false);
                player.clearSelectedPawn();
            }
       } else if(s.getPawn() != null && 
               s.getPawn().getOwner().equals(player)) {
           selected = s.getPawn();
           move = this.getValidMove(selected);
           if(move != null) {
                move.getSquares().getLast().setSelected(true);
                selected.setSelected(true);
                player.setSelectedPawn(selected);
           }           // TODO: Highlight valid move square
       }
   }
   
   public Player getCurrentPlayer() {
       return players.get(turn);
   }
   
   public void makeMakeMove(Move m) {
       m.getPawn().setMove(m);
   }
   
   public void moveFinished() {
       advanceTurn();
       players.get(turn).getMove();
   }
   
   public void advanceTurn() {
       turn = (turn + 1) % players.size();
       System.out.println(turn);
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
   public LinkedList<Move> getValidMoves (Player player) {
       LinkedList<Move> moves = new LinkedList<Move>();
    
       
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
        LinkedList<Square> squares = new LinkedList<Square>();
        Path path = player.getPath();
        PathSegment cur;
        int steps = 1;
        cur = path.getSegment(pw.getSquare());
        
        if(cur == null) {
            // Clicked Pawn is not on the Path
            // Must be on the home squares
            if(roll == 6) {
                //Must roll a 6 to enter the board
                Square s = path.getHomeSquare(pw);
                Square start = path.getFirst().getSquare();
                if(s != null && start.canOccupy(pw)) {
                   squares.add(start);
                   move = new Move(pw, squares ,roll);
                }
            }
        }
        else {
            // Clicked pawn is on the path
            //cur = cur.getNext();

            while(cur.getNext() != null) {
                /**
                 * Logic for determining valid moves!
                 * 
                 * Is block decides if the pawn can pass or occupy
                 * the square.
                 */
                PathSegment next = cur.getNext();
                squares.add(next.getSquare());
                
                if(next.getSquare().canPass(pw) && steps < roll) {
                    steps++;
                } else if (next.getNext() == null && 
                            next.getSquare().canOccupy(pw)) {
                   move = new Move(pw, squares, roll);
                } else if(roll == steps && 
                        next.getSquare().canOccupy(pw)) {
                   move = new Move(pw, squares, roll);
                   break;
                }
                cur = cur.getNext();
            }
        } 
       return move;
   }
   
   public Move getNextMove() {
       advanceTurn();
       return getCurrentPlayer().getMove();
   }
}
