/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seng271.group8.ludo.ui;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import seng271.group8.ludo.strategies.Strategy;

/**
 *
 * @author Alastairs
 */
public class PlayerSelectPanel extends JPanel {
    
    public PlayerSelectPanel(String name, Strategy[] strategies) {
        JLabel label = new JLabel(name);
        JComboBox select = new JComboBox(strategies);
        this.add(label);
        this.add(select);
    }
}
