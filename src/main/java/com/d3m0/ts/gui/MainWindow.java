package com.d3m0.ts.gui;

import com.d3m0.ts.core.Race;
import com.d3m0.ts.core.UsbAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class MainWindow {

    private JPanel Form1;
    private JButton startUSBButton;
    private JButton stopUSBButton;
    private JLabel label1;
    private Race race = new Race();

    public MainWindow() {
        startUSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                race.startTime(new UsbAction());
            }
        });
        stopUSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                race.stopTime(new UsbAction());
                label1.setText(race.getRiderNumber() + " " +
                        String.valueOf(race.elapsedTime()));
            }
        });
    }

    public void open() {
        JFrame frame = new JFrame("Timing System");
        frame.setContentPane(new MainWindow().Form1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
