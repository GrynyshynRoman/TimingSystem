import core.Action;
import core.KeyboardAction;
import core.RiderTime;
import core.UsbAction;

/**
 * Created by d3m0 on 21.10.2015.
 */
public class TimingSystem {
    public static void main(String[] args) {
        System.out.println("We are in main method");

        Action keyboardAction = new KeyboardAction();
        Action usbAction = new UsbAction();

        RiderTime riderTime = new RiderTime();

        riderTime.startTime(keyboardAction);
        riderTime.startTime(usbAction);
        riderTime.stopTime(keyboardAction);
        riderTime.stopTime(usbAction);

        System.out.println("test");
    }
}
