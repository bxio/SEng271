/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

import java.util.List;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.BoardClickEvent;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Player;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class BoardClickHandler extends BaseHandler<BoardClickEvent> {
    
    private Board board;
    private List<Player> players;
    
    public BoardClickHandler(List<Player> players, Board b, GameLogic game) {
        super(game);
        this.board = b;
        this.players = players;
    }
    
    public void handle(BoardClickEvent evt) {
        // Only handle board clicks for players if it is their turn
        if(players.contains(game.getCurrentPlayer()) 
                && game.getCurrentPlayer().getHasRolled()) {
            Square s = board.getSquareAt(evt.getClick().x, evt.getClick().y);
            System.out.println("Clicked stuff");
            if(s != null)
                game.squareClicked(s);
        }
    }

}
