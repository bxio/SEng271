/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.BoardClickEvent;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class BoardClickHandler implements Handler<BoardClickEvent> {
    
    private Board board;
    private GameLogic game;
    
    public BoardClickHandler(Board b, GameLogic game) {
        this.board = b;
        this.game = game;
    }
    
    public void handle(BoardClickEvent evt) {
        Square s = board.getSquareAt(evt.getClick().x, evt.getClick().y);
        if(s != null)
            game.squareClicked(s);
    }

}
