/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo;

import java.awt.Point;
import java.util.ArrayList;
import seng271.group8.ludo.model.Board;
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
   private Pawn selected = null;
   
   public  void squareClicked(Point p) {
       Square s = model.getSquareAt(p.x, p.y);
       
       /*if(s.) {
           
       }
       
       else if(s.getPawn() != null) {
           
       } else if () {
           
       }*/
               
   }
   
   public void advanceTurn() {
       turn = (turn + 1) % players.size();
   }
   
   public void setModel(Board b) {
    model = b;
   }
   
   public  ArrayList<Square> getValidMoves() {
       return null;
   }
   
   public  Player getTurn () {
       return null;
   }
}
