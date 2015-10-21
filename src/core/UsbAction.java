package core;

/**
 * Created by d3m0 on 21.10.2015.
 */
public class UsbAction implements Action {
    @Override
    public void start() {
        System.out.println("We are in UsbAction in start");
    }

    @Override
    public void stop() {
        System.out.println("We are in UsbAction stop method");
    }
}
