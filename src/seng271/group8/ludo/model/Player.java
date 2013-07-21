package seng271.group8.ludo.model;

import java.awt.Color;
import java.util.List;
import seng271.group8.ludo.Dice;
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
        private int id;
        private Boolean hasRolled = false;
        private int roll = 0;
        
       public Player(int num) {
           this.id = num;
       }
       
       public Pawn getSelectedPawn() {
           return selected;
       }
       
       public void setSelectedPawn(Pawn p) {
           this.selected = p;
       }
       
       public void clearSelectedPawn() {
           setSelectedPawn(null);
       }
       
       public Strategy getStrategy() {
           return this.strategy;
       }
       
       public void setStrategy(Strategy strat) {
           this.strategy = strat;
       }
       
       public int getRoll(Dice d) {
           return this.strategy.getRoll(d);
       }
       
       public Move getMove(List<Move> moves) {
           return this.strategy.getMove(moves);
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
       
       public int getId() {
           return this.id;
       }
       
       public int getRoll() {
           return roll;
       }
       
       public Boolean getHasRolled() {
           return hasRolled;
       }
       
       public void setHasRolled(Boolean hasRolled) {
            this.hasRolled = hasRolled;
       }
}