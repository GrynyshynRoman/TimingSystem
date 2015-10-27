package com.d3m0.ts.core;

import com.d3m0.ts.gui.InputNumberDialog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class Race {
    private Rider rider;
    private Map<String, Rider> ridersOnTrack = new HashMap<String, Rider>();
    private String finishNumber = "";
    private String defaultNumber;

    public Map<String, Rider> getRidersOnTrack() {
        return ridersOnTrack;
    }

    public String getFinishNumber() {
        return finishNumber;
    }

    public void setDefaultNumber(String defaultNumber) {
        this.defaultNumber = defaultNumber;
    }

    public Rider startTime(Action action) {
        action.start();
        rider = new Rider();
        ridersOnTrack.put(getStartNumberFromUI(), rider);
        return rider;
    }

    public Rider stopTime(Action action) {
        action.stop();
        long stopTime = System.currentTimeMillis();

        finishNumber = getFinishNumberFromUI();
        rider = ridersOnTrack.get(finishNumber);
        rider.setRiderFinishTime(stopTime);

        rider.setTimeOnTrack(rider.calculateTimeOnTrack());
        return rider;
    }

    private String getStartNumberFromUI() {
        return (defaultNumber.isEmpty()) ? new InputNumberDialog().getNumber("Who's starting?") : defaultNumber;
    }

    private String getFinishNumberFromUI() {
        return (defaultNumber.isEmpty()) ? new InputNumberDialog().getNumber("Who's finished?") : defaultNumber;
    }

    public void removeFinishedRider() {
        getRidersOnTrack().remove(getFinishNumber());
    }
}
