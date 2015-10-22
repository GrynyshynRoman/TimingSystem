package com.d3m0.ts.core;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class RiderTime {
    static long startTime;
    static long stopTime;

    public static long startTime(Action action) {
        action.start();
        return startTime = System.currentTimeMillis();
    }

    public static long stopTime(Action action) {
        action.stop();
        return stopTime = System.currentTimeMillis();
    }

    public static String elapsedTime() {
        return String.valueOf((stopTime - startTime) / 1000.00);
    }
}
