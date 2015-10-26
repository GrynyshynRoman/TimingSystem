package com.d3m0.ts.core;

import com.d3m0.ts.gui.InputNumberDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class Race {
    Rider rider;
    List<Rider> ridersOnTrack = new ArrayList<Rider>();


    public Rider startTime(Action action) {
        action.start();
        rider = new Rider();
        rider.start();
        if (rider.getRiderNumber() == null) {
            rider.setRiderNumber(new InputNumberDialog().getNumber("Who's starting?"));
        }

        ridersOnTrack.add(rider);
        for (Rider rider : ridersOnTrack) {
            // Add output to form
        }
        return rider;
    }

    public Rider stopTime(Action action) {
        action.stop();
        long stopTime = System.currentTimeMillis();
        String number = new InputNumberDialog().getNumber("Who's finished?");
        Rider finishedRider = new Rider();

        for (Rider riderOnTrack : ridersOnTrack) {
            if (riderOnTrack.getRiderNumber().equals(number)) {
                riderOnTrack.setRiderEndTime(stopTime);
                finishedRider = riderOnTrack;
            }
        }
        ridersOnTrack.remove(finishedRider);
        return finishedRider;
    }
}
