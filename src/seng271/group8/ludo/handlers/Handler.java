/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

/**
 *
 * @author alastair
 */
public interface Handler<T>  {
    //private T evt;
    public void handle(T evt);
    /*public Boolean handle(GameEvent evt) {
        try {
            this.evt = (T) evt;
            return true;
        } catch (ClassCastException e ) {
            System.out.println("Handler " + this.getClass() + " is not"
                    + "Compatible with " + evt.getClass());
            return false;
        }
    }*/
}
