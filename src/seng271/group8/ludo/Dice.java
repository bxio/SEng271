package seng271.group8.ludo;

/**Dice Used with Ludo game. This one isn't rigged, I promise.
 * @author bill
 */
import java.util.Random;
import java.util.ArrayList;
public class Dice {
    private ArrayList<Integer> log;
    private int result;
    private Random generator;
    
    public Dice(){
        generator = new Random();
        log = new ArrayList<Integer>();
    }
	/** Rolls the dice and returns the result. 
	 * Also adds the result to the dice log.
	 * 
	 * @return			An integer between 1 and 6 (as the result of the dice roll.)
	 */
    public int roll(){
        this.result = generator.nextInt(5)+1;
        log.add(new Integer(result));
        return this.result;
    }
	/** returns a log of all of the dice results.
	 * 
	 * @return			ArrayList<Integer> of all of the results of the die
	 */
    public ArrayList<Integer> getResults(){
        return this.log;
    }
}
