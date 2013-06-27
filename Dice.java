/**
 *
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

    public int roll(){
        this.result = generator.nextInt(5)+1;
        log.add(new Integer(result));
        return this.result;
    }
    public ArrayList<Integer> getResults(){
        return this.log;
    }
}
