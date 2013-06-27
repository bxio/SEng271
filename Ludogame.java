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
        
        blue.setColour("Blue");
        yellow.setColour("Yellow");
        green.setColour("Green");
        red.setColour("Red");
        
        System.out.println(dice.roll()+dice.roll()+dice.roll());
        System.out.println(dice.getResults());
    }
}
