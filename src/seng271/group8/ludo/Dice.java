package seng271.group8.ludo;


import java.util.Random;
import java.util.ArrayList;
import java.util.List;
/** Dice Used with Ludo game. This one isn't rigged, I promise.
 * 
 * @author bill
 */
public class Dice {
    private List<Integer> log;
    private int result;
    private Random generator;
	private boolean debug = false;
	private List<Integer> rig;
    
    public Dice(){
        generator = new Random();
        log = new ArrayList<Integer>();
    }
	/** Rolls the dice and returns the result. 
	 * Also adds the result to the dice log.
	 * If this.debug is set, the dice instead returns the first 
	 * 
	 * @return			An integer between 1 and 6 (as the result of the dice roll.)
	 */
    public int roll(){
		if(this.debug){
			return 4;
		}else{
			this.result = generator.nextInt(6)+1;
			log.add(new Integer(result));
			return this.result; 
		}
    }
	/** returns a log of all of the dice results.
	 * 
	 * @return			ArrayList<Integer> of all of the results of the die
	 */
    public List<Integer> getResults(){
        return this.log;
    }
}
