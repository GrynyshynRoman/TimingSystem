package com.d3m0.ts.core;

/**
 * Created by d3m0 on 22.10.2015.
 */
public class UsbAction implements Action {
    @Override
    public void start() {
        System.out.println("Started by usb");
    }

    @Override
    public void stop() {
        System.out.println("Stopped by usb");
    }
}
