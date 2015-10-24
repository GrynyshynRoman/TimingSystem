package com.d3m0.ts.core;

/**
 * Created by d3m0 on 24.10.2015.
 */
public class Rider {
    private String riderNumber;
    private long riderStartTime;
    private long riderEndTime;

    public String getRiderNumber() {
        return riderNumber;
    }

    public void setRiderNumber(String riderNumber) {
        this.riderNumber = riderNumber;
    }

    public long getRiderStartTime() {
        return riderStartTime;
    }

    public void setRiderStartTime(long riderStartTime) {
        this.riderStartTime = riderStartTime;
    }

    public long getRiderEndTime() {
        return riderEndTime;
    }

    public void setRiderEndTime(long riderEndTime) {
        this.riderEndTime = riderEndTime;
    }

    public void start() {
        riderStartTime = System.currentTimeMillis();
    }

    public void stop() {

    }
}
