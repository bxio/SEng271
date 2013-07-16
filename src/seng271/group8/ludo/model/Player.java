package seng271.group8.ludo.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import seng271.group8.ludo.strategies.Strategy;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bill
 */
public class Player {
	private Color colour;
	private Strategy strategy;
        private LinkedList<Square> path;
        private ArrayList<Pawn> pawns;
        private Pawn selected;
        private int playerNum;
        
       public Player(int num) {
           this.playerNum = num;
       }
       
       public Pawn getSelectedPawn() {
           return selected;
       }
       
       public void setSelectedPawn(Pawn p) {
           
       }
       
       public void setStrategy(Strategy strat) {
           this.strategy = strat;
       }
       
       public void setPath(LinkedList<Square> path) {
           this.path = path;
       }
       
       public LinkedList<Square> getPath() {
           return this.path;
       }
       
       public void setPawns(ArrayList<Pawn> pawns) {
           this.pawns = pawns;
       }

}