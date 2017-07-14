/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.joshking.anuyog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 13001381
 */
@SuppressWarnings("serial")
public class AnuPanel extends JFrame implements Runnable {
    JPanel panel = new JPanel();
    JLabel labelTried = new JLabel("Null"), labelTimes = new JLabel("Null");
    JLabel author = new JLabel("Created by Josh King");
    GridBagConstraints constraints = new GridBagConstraints();

    public AnuPanel() {
        super("What\'s your name?");

        panel = new JPanel(new GridBagLayout());

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        Thread th = new Thread(this);
        th.start();

        // set the jframe size and location, and make it visible
        panel.setPreferredSize(new Dimension(300, 50));

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            while (!Anuyog.name.equalsIgnoreCase(Anuyog.anu)) {
                for (int i = 0; i < Anuyog.counter; i++) {
                    constraints.gridx = 0;
                    constraints.gridy = 0;
                    labelTried.setText("Tried: " + Anuyog.name);
                    panel.add(labelTried, constraints);

                    String tries = Integer.toString(Anuyog.counter);
                    constraints.gridx = 1;
                    constraints.gridy = 0;
                    labelTimes.setText("Time(s): " + tries);
                    panel.add(labelTimes, constraints);

                    Thread.sleep(100); // stopping processing for 100
                    // miliseconds
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
