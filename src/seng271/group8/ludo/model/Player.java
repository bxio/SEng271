package seng271.group8.ludo.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import seng271.group8.ludo.Die;
import seng271.group8.ludo.strategies.Strategy;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bill
 */
public class Player extends GameEntity {
		private Color colour;
		private Strategy strategy;
        private Path path;
        private List<Pawn> pawns;
        private Pawn selected;
        private int id;
        private Boolean hasRolled = false;
        private int roll = 0;
		private Boolean human = false;
		private Boolean finished = false;

        
       public Player(int num) {
           this.id = num;
       }
	   public Boolean getIsFinished() {
		   return this.finished;
	   }
	   
	   public void setHuman(Boolean human) {
		   this.human = human;
	   }
	   
	   public Boolean isHuman(){
		   return this.human;
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
       
       public int getRoll(Die d) {
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
	   
	   public boolean hasPawnsAtHome(){
		   for(Pawn p : this.pawns){
			   if(this.path.getHomeSquares().contains(p.getSquare())){
				   //pawn is at home.
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   public List<Pawn> getPawnsAtHome(){
		   List<Pawn> assemble = new ArrayList<Pawn>();
		   for(Pawn p : this.pawns){
			   if(this.path.getHomeSquares().contains(p.getSquare())){
				   //this pawn is at home
				   assemble.add(p);
			   }
		   }
		   return assemble;
	   }
	   
	   public boolean startSpaceIsEmptyOrOccupiedByOpponents(){
		   Pawn p = this.path.getFirst().getSquare().getPawn();
		   if(p != null){
			   //someone is occupying the start space.
			   
			   //let's see if it's a friendly
			   if(this.pawns.contains(p)){
				   return true;
			   }else{
				   return false;
			   }
		   }
		   return false;
	   }
	   
	   public boolean shouldPrioritizeMovingOutOfHome(){
		   return (this.hasPawnsAtHome() && this.startSpaceIsEmptyOrOccupiedByOpponents());
	   }
}