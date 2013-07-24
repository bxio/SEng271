/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.handlers;

import java.util.List;
import seng271.group8.ludo.GameController;
import seng271.group8.ludo.GameLogic;
import seng271.group8.ludo.events.BoardClickEvent;
import seng271.group8.ludo.events.MoveEvent;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Move;
import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.Player;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class BoardClickHandler extends BaseHandler<BoardClickEvent> {
    
    private Board board;
    private List<Player> players;
    private enum ClickStates {
        Selected,
        Rolled
    }
    private Pawn selected;
    private Player player;
    private Move move;
    
    public BoardClickHandler(List<Player> players, Board b, GameLogic game) {
        super(game);
        this.board = b;
        this.players = players;
    }
    
    public void handle(BoardClickEvent evt) {
        // Only handle board clicks for players if it is their turn
        // and they have already rolled
        if(players.contains(game.getCurrentPlayer()) 
                && game.getCurrentPlayer().getHasRolled()) {
            Square s = board.getSquareAt(evt.getClick().x, evt.getClick().y);
            System.out.println("Clicked Square:" + s.getPosition().x + " " + s.getPosition().y);
            if(s != null)
                squareClicked(s);
        }         
    }
    
    public void squareClicked(Square s) {
       move = null;
       
       player = game.getCurrentPlayer();
       selected = player.getSelectedPawn();
       
       if(s.getPawn() != null && 
               s.getPawn().getOwner().equals(player)) {
           setSelectedPawn(s.getPawn());
       } else if(selected != null) {
            move = game.getValidMove(selected);
            if(move != null) {
                queueMove(s);
            } 
       } 
    }
    
    public void queueMove(Square s) {
        if(move.getSquares().getLast().equals(s)) {
                    GameController.publish(new MoveEvent(move));     
                    move.getSquares().getLast().setSelected(Boolean.FALSE);
        }
        selected.setSelected(false);
        player.clearSelectedPawn();
            
    }
    
    public void setSelectedPawn(Pawn p) {
        selected = p;
        move = game.getValidMove(selected);
        selected.setSelected(true);
        player.setSelectedPawn(selected);
        
        if(move != null) {
            move.getSquares().getLast().setSelected(true);
        }
    }
}
