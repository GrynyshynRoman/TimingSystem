package com.d3m0.ts.core;

import com.d3m0.ts.gui.InputNumberDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class Race {
    private Rider rider;
    private List<Rider> ridersOnTrack = new ArrayList<Rider>();
    private String finishNumber = "";
    private String startNumber = "";

    public List<Rider> getRidersOnTrack() {
        return ridersOnTrack;
    }

    public String getFinishNumber() {
        return finishNumber;
    }

    public String getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public void setFinishNumber(String finishNumber) {
        this.finishNumber = finishNumber;
    }

    public Rider startTime(Action action) {
        action.start();
        rider = new Rider();
        rider.start();
        if (getStartNumber().isEmpty()) {
            rider.setRiderNumber(new InputNumberDialog().getNumber("Who's starting?"));
        } else {
            rider.setRiderNumber(getStartNumber());
            setStartNumber("");
        }
        ridersOnTrack.add(rider);
        return rider;
    }

    public Rider stopTime(Action action) {
        action.stop();
        long stopTime = System.currentTimeMillis();
        if (getFinishNumber().isEmpty()) {
            setFinishNumber(new InputNumberDialog().getNumber("Who's finished?"));
        }
        Rider finishedRider = new Rider();

        for (Rider riderOnTrack : ridersOnTrack) {
            if (riderOnTrack.getRiderNumber().equals(getFinishNumber())) {
                riderOnTrack.setRiderEndTime(stopTime);
                finishedRider = riderOnTrack;
            }
        }
        setFinishNumber("");
        return finishedRider;
    }
}
