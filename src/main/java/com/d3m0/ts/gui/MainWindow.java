package com.d3m0.ts.gui;

import com.d3m0.ts.core.Race;
import com.d3m0.ts.core.Rider;
import com.d3m0.ts.core.UsbAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class MainWindow {

    private JPanel Form1;
    private JButton startUSBButton;
    private JButton stopUSBButton;
    private JLabel ridersOnTrackLabel;
    private JLabel totalRidersOnTrackLabel;
    private JTextField numberByDefault;
    private Race race = new Race();

    public MainWindow() {
        totalRidersOnTrackLabel.setText(String.valueOf(race.getRidersOnTrack().size()));
        stopUSBButton.setEnabled(false);

        startUSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                race.setDefaultNumber(numberByDefault.getText());
                race.startTime(new UsbAction());
                showResults(race.getRidersOnTrack());
                totalRidersOnTrackLabel.setText(String.valueOf(race.getRidersOnTrack().size()));
                stopUSBButton.setEnabled(true);
            }
        });

        stopUSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                race.setDefaultNumber(numberByDefault.getText());
                race.stopTime(new UsbAction());
                showResults(race.getRidersOnTrack());
                race.removeFinishedRider();
                totalRidersOnTrackLabel.setText(String.valueOf(race.getRidersOnTrack().size()));
                if (race.getRidersOnTrack().size() == 0) {
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
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showResults(Map<String, Rider> ridersOnTrack) {

        String output = "";
        for (Map.Entry<String, Rider> rider : ridersOnTrack.entrySet()) {
            if (rider.getValue().getRiderFinishTime() == 0) {
                output += "<html> #" + rider.getKey() + " : is on track <br>";
            } else {
                output += "<html> #" + rider.getKey() + " : " + rider.getValue().getTimeOnTrack() + "<br>";
            }
        }
        ridersOnTrackLabel.setText(output);
    }
}
