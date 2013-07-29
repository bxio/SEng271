/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo;

import java.util.LinkedList;
import java.util.List;
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
   private List<Player> players, rankings;
   private int turn = 0; // Player 1 always starts
   private int roll = 6; // Hardcoded for testing
   private Dice dice;
   private String stateMessage;
   private Boolean shouldBlock;

   public GameLogic(Board b, Dice d) {
       this.model = b;
       this.dice = d;
       this.players = b.getPlayers();
       this.rankings = new LinkedList<Player>();
   }
   
   public Player getCurrentPlayer() {
       return players.get(turn);
   }
   
   public void makeMakeMove(Move m) {
       this.getCurrentPlayer().setHasRolled(false);
       m.getPawn().setMove(m);
   }
   
   public Boolean checkForWin() {
       Boolean gameOver = true;
       for(Player p : this.players) {
           if(p.getIsFinished() && !rankings.contains(p)) {
               rankings.add(p);
           } else {
               gameOver = false;
           }         
       }
       
       return gameOver;
   }
   
   /**
    * 
    * @return The player rankings from 1st-4th place 
    */
   public List<Player> getGameResults() {
       return this.rankings;
   }
   
   public void makeKickMove(Move m) {
       m.getPawn().setMove(m);
   }
   
   public void advanceTurn() {
       Player last = players.get(turn);
       last.setSelected(Boolean.FALSE);
       turn = (turn + 1) % players.size();
       if(this.getCurrentPlayer().getIsFinished()) {
           this.advanceTurn();
       } else {
            Player cur = players.get(turn);
            cur.setSelected(Boolean.TRUE);
       }
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
           if(m != null)
               moves.add(m);
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
        int steps = 0;
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
                   checkForKick(start, move);
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
                 * Each square decides if the pawn can pass or occupy
                 * the square.
                 */
                PathSegment next = cur.getNext();
                squares.add(next.getSquare());
                steps++;
                
                if(roll == steps && 
                        next.getSquare().canOccupy(pw)) {
                   move = new Move(pw, squares, roll);
                   checkForKick(next.getSquare(),move);
                   break;
                }      
                else if (next.getNext() == null && 
                            next.getSquare().canOccupy(pw)) {
                   move = new Move(pw, squares, roll);
                   break;
                }
                
                cur = next;
            }
        } 
       return move;
   }
   
   private void checkForKick(Square s, Move move) {
        Pawn pw = s.getPawn();
        
        if(pw != null) {
                LinkedList<Square> squares = new LinkedList<Square>();
            for(Square sq : pw.getOwner().getPath().getHomeSquares()) {
              if(sq.getPawn() == null) {
                  squares.add(sq);
                  pw.setPosition(sq);
                  break;
              } 
          }
             move.setKickMove(new Move(pw, squares));
        }
   }
   
   public void setRoll(int i) {
       
   }
   
   public int generateRoll() {
       if(roll == -1)
           this.roll = dice.roll();
       return this.roll;
   }
   
   public void setBlockInput(Boolean block) {
       this.shouldBlock = block;
   }
   
   public Boolean shouldBlockInput() {
       return false;
   }
   
   public int getRoll() {
       return this.roll;
   }
   
   public int makeRoll() {
       Player p = getCurrentPlayer();
       roll = p.getRoll(dice);
       if(roll != -1) {
           p.setHasRolled(true);
           model.setMessage("Player " + (p.getId()+1) + " rolled " + roll +"!");
       }
       return roll;
   }
   
   public Move getNextMove() {    
       Player p = getCurrentPlayer();
       return p.getMove(getValidMoves(p));
   }
}
