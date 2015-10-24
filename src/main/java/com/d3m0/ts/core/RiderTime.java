package com.d3m0.ts.core;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class RiderTime {
    Rider rider;

    public void startTime(Action action) {
        action.start();
        rider = new Rider();
        rider.start();
    }

    public void stopTime(Action action) {
        action.stop();
        rider.stop();
    }

    public static void elapsedTime() {

    }
}
