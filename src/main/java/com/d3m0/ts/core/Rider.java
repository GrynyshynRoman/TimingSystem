package com.d3m0.ts.core;

/**
 * Created by d3m0 on 24.10.2015.
 */
public class Rider {
    private long riderStartTime;
    private long riderEndTime;
    private Double timeOnTrack;

    Rider() {
        setRiderStartTime(System.currentTimeMillis());
    }

    public void setRiderStartTime(long riderStartTime) {
        this.riderStartTime = riderStartTime;
    }

    public long getRiderFinishTime() {
        return riderEndTime;
    }

    public void setRiderFinishTime(long riderEndTime) {
        this.riderEndTime = riderEndTime;
    }

    public Double getTimeOnTrack() {
        return timeOnTrack;
    }

    public void setTimeOnTrack(Double timeOnTrack) {
        this.timeOnTrack = timeOnTrack;
    }

    public Double calculateTimeOnTrack() {
        return (riderEndTime - riderStartTime) / 1000.00;
    }
}
