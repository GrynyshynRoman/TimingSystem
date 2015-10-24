package com.d3m0.ts.core;

import com.d3m0.ts.gui.InputNumberDialog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class Race {
    Rider rider;
    StopWatch stopWatch;
    Map<String, StopWatch> ridersOnTrack = new HashMap<String, StopWatch>();

    public void startTime(Action action) {
        action.start();
        rider = new Rider();
        stopWatch = new StopWatch();
        stopWatch.setStartTime(rider.start());
        if (rider.getRiderNumber() == null) {
            rider.setRiderNumber(new InputNumberDialog().getNumber("Who's starting?"));
        }

        ridersOnTrack.put(rider.getRiderNumber(), stopWatch);
    }

    public void stopTime(Action action) {
        long stopTime = System.currentTimeMillis();
        action.stop();
        rider.stop();
        String finished = new InputNumberDialog().getNumber("Who's finished?");
        rider.setRiderEndTime(stopTime);
    }

    public double elapsedTime() {
        return (rider.getRiderEndTime() - rider.getRiderStartTime()) / 1000.00;
    }

    public String getRiderNumber() {
        return rider.getRiderNumber();
    }
}
