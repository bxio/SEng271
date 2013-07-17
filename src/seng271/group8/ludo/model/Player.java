package seng271.group8.ludo.model;

import java.awt.Color;
import java.util.List;
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
        private Path path;
        private List<Pawn> pawns;
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
       
       public Strategy getStrategy() {
           return this.strategy;
       }
       
       public void setStrategy(Strategy strat) {
           this.strategy = strat;
       }
       
       public void getMove() {
           this.strategy.getMove(this, playerNum);
       }
       
       public void setPath(Path path) {
           this.path = path;
       }
       
       public Path getPath() {
           return this.path;
       }
       
       public void setPawns(List<Pawn> pawns) {
           this.pawns = pawns;
       }
       
       public List<Pawn> getPawns() {
           return this.pawns;
       }

}