/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.actions;

import java.awt.Point;

/**
 *
 * @author alastair
 */
public class BoardClickEvent extends GameEvent {

    public BoardClickEvent(Object source, Point coords) {
        super(source);
    }
}
