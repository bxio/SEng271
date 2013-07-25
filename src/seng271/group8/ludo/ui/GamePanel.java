/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import seng271.group8.ludo.graphics.Animation2DSeries;
import seng271.group8.ludo.graphics.AnimationBuilder;
import seng271.group8.ludo.graphics.Animator;
import seng271.group8.ludo.graphics.Layer;
import seng271.group8.ludo.graphics.LudoGraphic;
import seng271.group8.ludo.graphics.MessageGraphic;
import seng271.group8.ludo.graphics.MoveBuilder;
import seng271.group8.ludo.graphics.PawnGraphic;
import seng271.group8.ludo.graphics.PulseBuilder;
import seng271.group8.ludo.graphics.Renderer2D;
import seng271.group8.ludo.graphics.ScaleAnimation;
import seng271.group8.ludo.graphics.SquareGraphic;
import seng271.group8.ludo.graphics.TranslateAnimation;
import seng271.group8.ludo.model.Board;
import seng271.group8.ludo.model.Pawn;
import seng271.group8.ludo.model.PawnChangeListener;
import seng271.group8.ludo.model.Square;

/**
 *
 * @author Alastairs
 */
public class GamePanel extends JComponent implements ComponentListener, FocusListener {
    
    private Board board;
    private Renderer2D renderer;
    private Animator animationThread;
    private Map<Class<? extends AnimationBuilder>, AnimationBuilder> animationBuilders;
    
    public GamePanel(Board b) {
        this.setOpaque(true);
        this.board = b;
        this.renderer = new Renderer2D();
        
        this.animationThread = new Animator(this);
        // make sure the thread stops when the JFrame is closed
        this.animationThread.setDaemon(true);
        this.animationThread.start();
        
        animationBuilders = new HashMap<Class<? extends AnimationBuilder>, 
                            AnimationBuilder>();
        animationBuilders.put(MoveBuilder.class, new MoveBuilder());
        animationBuilders.put(PulseBuilder.class, new PulseBuilder());
        
        
        Layer squareLayer = new Layer();
        
        for(Square s : board.getSquareList()) {
            s.setRendering(new SquareGraphic(s));
            s.addPropertyChangeListener(new PawnChangeListener(animationThread,
                    animationBuilders));
            squareLayer.add(s.getRendering());
            //squareLayer.add(s.getRendering(), s.getPosition().x, s.getPosition().y);
        }
        
        renderer.addLayer(squareLayer);
        Layer pawnLayer = new Layer();
        
        for(Pawn pw : board.getPawnList()) {
            pw.setRendering(new PawnGraphic(pw));
            pawnLayer.add(pw.getRendering());
            pw.addPropertyChangeListener(new PawnChangeListener(
                    animationThread,animationBuilders));
        }
        
        renderer.addLayer(pawnLayer);
        Layer uiLayer = new Layer();
        LudoGraphic mes = new MessageGraphic(new Point(5,5), "Game started");
        uiLayer.add(mes);
        renderer.addLayer(uiLayer);
        Animation2DSeries series = new Animation2DSeries();
        ScaleAnimation sc = new ScaleAnimation(mes, 1.5f,1000, "bounce");
        TranslateAnimation ts = new TranslateAnimation(mes,new Point(5,0),1000);
        series.add(sc);
        series.add(ts);
        
        animationThread.addAnimation(series);
        
        GameMouseListener gl = new GameMouseListener(this);
        this.addMouseListener(gl);
        this.addMouseMotionListener(gl);
        this.addComponentListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       
       super.paintComponent(g);
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       
       //System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
       //long start = System.currentTimeMillis();
       
       renderer.paint(g);
       //System.out.println(System.currentTimeMillis()-start);
    }
    
    public void highlightSquare(Point p) {
        
    }
    
    public Renderer2D getRenderer2D() {
        return this.renderer;
    }
    
    public Board getBoard() {
        return this.board;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        renderer.resize(this.getSize());
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        renderer.resize(this.getSize());    
    }

    @Override
    public void componentShown(ComponentEvent e) {
        renderer.resize(this.getSize());
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        renderer.resize(this.getSize());
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
