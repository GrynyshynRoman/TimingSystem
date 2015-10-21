/**
 * Created by d3m0 on 21.10.2015.
 */
public class RiderTime {
    public void startTime(Action action) {
        System.out.println("We are in RiderTime in start");
        action.start();
    }

    public void stopTime(Action action) {
        System.out.println("We are in RiderTime stop method");
        action.stop();
    }
}
