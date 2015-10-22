package com.d3m0.ts.core;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class KeyboardAction implements Action {
    @Override
    public void start() {
        System.out.println("Started by keyboard");
    }

    @Override
    public void stop() {
        System.out.println("Stopped by keyboard");
    }
}
