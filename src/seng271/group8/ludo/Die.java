package seng271.group8.ludo;


import java.util.Random;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD:src/seng271/group8/ludo/Dice.java
/** Dice Used with Ludo game. This one isn't rigged, I promise.
 * 
 * @author bill
 */
public class Dice {
    private List<Integer> log;
    private int result;
    private Random generator;
	private boolean cheat = true;
	private List<Integer> rig;
=======

import seng271.group8.ludo.model.GameEntity;
public class Die extends GameEntity {
    private List<Integer> log;
    private int result;
    private Random generator;
    public static final String ROLL = "ROLL";
>>>>>>> dieupdate:src/seng271/group8/ludo/Die.java
    
    public Die(){
        generator = new Random();
        log = new ArrayList<Integer>();
		rig = new ArrayList<Integer>();
		if(cheat){
			System.out.println("We're using the cheater die.");
			//add the results you want the rigged dice to return.
			//blue
			rig.add(6);
			rig.add(5);
			//yellow
			rig.add(6);
			rig.add(1);
			//green
			rig.add(6);
			rig.add(1);
			//red
			rig.add(6);
			rig.add(1);
			//blue again
			rig.add(6);
			rig.add(2);
		}
		
		
    }
	/** Rolls the dice and returns the result. 
	 * Also adds the result to the dice log.
	 * If this.debug is set, the dice instead returns the first 
	 * 
	 * @return			An integer between 1 and 6 (as the result of the dice roll.)
	 */
<<<<<<< HEAD:src/seng271/group8/ludo/Dice.java
    public int roll(){
		if(this.cheat){
			if(rig.isEmpty()){
				this.result = generator.nextInt(6)+1;
			}else{
				this.result = rig.get(0);
				rig.remove(0);
			}
			log.add(new Integer(result));
			return this.result; 
			
		}else{
			this.result = generator.nextInt(6)+1;
			log.add(new Integer(result));
			return this.result; 
		}
=======
    public int roll() {
    	int oldResult = this.result;
        this.result = generator.nextInt(6)+1;
        log.add(new Integer(result));
        this.pcs.firePropertyChange(ROLL, oldResult, this.result);
        return this.result; 
>>>>>>> dieupdate:src/seng271/group8/ludo/Die.java
    }
	/** returns a log of all of the dice results.
	 * 
	 * @return			ArrayList<Integer> of all of the results of the die
	 */
    public List<Integer> getResults(){
        return this.log;
    }
}
