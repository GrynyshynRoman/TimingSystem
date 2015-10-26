package com.d3m0.ts.gui;

import com.d3m0.ts.core.Race;
import com.d3m0.ts.core.Rider;
import com.d3m0.ts.core.UsbAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
                if (!numberByDefault.getText().isEmpty()) {
                    race.setStartNumber(numberByDefault.getText());
                }
                race.startTime(new UsbAction());
                stopUSBButton.setEnabled(true);
                totalRidersOnTrackLabel.setText(String.valueOf(race.getRidersOnTrack().size()));
                showResults(race.getRidersOnTrack());
            }
        });

        stopUSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!numberByDefault.getText().isEmpty()) {
                    race.setFinishNumber(numberByDefault.getText());
                }
                Rider rider = race.stopTime(new UsbAction());
                showResults(race.getRidersOnTrack());
                race.getRidersOnTrack().remove(rider);
                totalRidersOnTrackLabel.setText(String.valueOf(race.getRidersOnTrack().size()));
                if (race.getRidersOnTrack().size() == 0) {
                    stopUSBButton.setEnabled(false);
                }
            }
        });

        showResults(race.getRidersOnTrack());
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

    private void showResults(List<Rider> ridersOnTrack) {
        String output = "";
        for (Rider rider : ridersOnTrack) {
            if (rider.getRiderEndTime() == 0) {
                output += "<html> #" + rider.getRiderNumber() + " : is on track <br>";
            } else {
                output += "<html> #" + rider.getRiderNumber() + " : " + rider.getTimeOnTrack() + "<br>";
            }
        }
        ridersOnTrackLabel.setText(output);
    }
}
