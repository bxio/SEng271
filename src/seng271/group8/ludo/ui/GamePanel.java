/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import seng271.group8.ludo.graphics.LudoGraphic;
import seng271.group8.ludo.graphics.SquareGraphic;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.BoardConfig;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class GamePanel extends JPanel {
    
    private Board board;
    private Square[] squares;
    private ArrayList<LudoGraphic> graphics;
    
    public GamePanel(Board b) {
        this.board = b;
        this.squares = board.getSquares();
        this.graphics = new ArrayList<LudoGraphic>();
        //this.setBackground(Color.BLUE);
        
        for(Square s : squares) {
            graphics.add(new SquareGraphic(s));
        }
    } 
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       
       Dimension squareSize = computeSquareSize();
        
       for(LudoGraphic gr : graphics) {
           gr.paint(g, squareSize);
       }
       
    }
    
    private Dimension computeSquareSize() {
        int side = Math.min(this.getHeight(), this.getWidth())/BoardConfig.WIDTH;
        System.out.println("Width:" + this.getWidth() + " Height" + this.getHeight());
        return new Dimension(side,side);
    }
}
