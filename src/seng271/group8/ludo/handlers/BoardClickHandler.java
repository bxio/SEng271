/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

import java.util.ArrayList;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.BoardClickEvent;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Player;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class BoardClickHandler implements Handler<BoardClickEvent> {
    
    private Board board;
    private GameLogic game;
    private ArrayList<Player> players;
    
    public BoardClickHandler(ArrayList<Player> players, Board b, GameLogic game) {
        this.board = b;
        this.game = game;
        this.players = players;
    }
    
    public void handle(BoardClickEvent evt) {
        // Only handle board clicks for players if it is their turn
        if(players.contains(game.getCurrentPlayer())) {
            Square s = board.getSquareAt(evt.getClick().x, evt.getClick().y);

            s.getRendering().setScale(0.3f);
            if(s != null)
                game.squareClicked(s);
        }
    }

}
