/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.actions;

/**
 *
 * @author alastair
 */
public interface Handler<T extends GameEvent>  {
    public void handle(T evt);
}
