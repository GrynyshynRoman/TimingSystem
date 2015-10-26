package com.d3m0.ts.gui;

import com.d3m0.ts.core.Race;
import com.d3m0.ts.core.Rider;
import com.d3m0.ts.core.UsbAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class MainWindow {

    private JPanel Form1;
    private JButton startUSBButton;
    private JButton stopUSBButton;
    private JLabel label1;
    private JLabel ridersOnTrackLabel;
    private Race race = new Race();
    private List<Rider> ridersOnTrack = new ArrayList<Rider>();

    public MainWindow() {
        ridersOnTrackLabel.setText(String.valueOf(ridersOnTrack.size()));
        stopUSBButton.setEnabled(false);
        startUSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ridersOnTrack.add(race.startTime(new UsbAction()));
                stopUSBButton.setEnabled(true);
                ridersOnTrackLabel.setText(String.valueOf(ridersOnTrack.size()));
            }
        });
        stopUSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rider rider = race.stopTime(new UsbAction());
                ridersOnTrack.remove(rider);
                ridersOnTrackLabel.setText(String.valueOf(ridersOnTrack.size()));
                label1.setText("#" + rider.getRiderNumber() + " : " + rider.getTimeOnTrack());
                if (ridersOnTrack.size() == 0) {
                    stopUSBButton.setEnabled(false);
                }
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
