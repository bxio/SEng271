package seng271.group8.ludo;

/**Dice Used with Ludo game. This one isn't rigged, I promise.
 * @author bill
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import seng271.group8.ludo.model.GameEntity;
public class Die extends GameEntity {
    private List<Integer> log;
    private int result;
    private Random generator;
    public static final String ROLL = "ROLL";
    
    public Die(){
        generator = new Random();
        log = new ArrayList<Integer>();
    }
	/** Rolls the dice and returns the result. 
	 * Also adds the result to the dice log.
	 * 
	 * @return			An integer between 1 and 6 (as the result of the dice roll.)
	 */
    public int roll() {
    	int oldResult = this.result;
        this.result = generator.nextInt(6)+1;
        log.add(new Integer(result));
        this.pcs.firePropertyChange(ROLL, oldResult, this.result);
        return this.result; 
    }
	/** returns a log of all of the dice results.
	 * 
	 * @return			ArrayList<Integer> of all of the results of the die
	 */
    public List<Integer> getResults(){
        return this.log;
    }
}
