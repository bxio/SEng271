/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bill
 */
public class Ludogame {

    public static void main(String[] args) {
        Player blue, yellow, green, red;
        blue = new Player();
        yellow = new Player();
        green = new Player();
        red = new Player();
        Dice dice = new Dice();
		Player winner = null;
		
        
        blue.initPlayer("Blue",1,1);
        yellow.initPlayer("Yellow",2,11);
        green.initPlayer("Green",3,21);
        red.initPlayer("Red",4,31);
		
		System.out.println(green.getReport());

    }
}
