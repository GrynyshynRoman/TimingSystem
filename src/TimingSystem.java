/**
 * Created by d3m0 on 21.10.2015.
 */
public class TimingSystem {
    public static void main(String[] args) {
        System.out.println("We are in main method");

        KeyboardAction keyboardAction = new KeyboardAction();
        UsbAction usbAction = new UsbAction();
        RiderTime riderTime = new RiderTime();

        riderTime.startTime(keyboardAction);
        riderTime.startTime(usbAction);
        riderTime.stopTime(keyboardAction);
        riderTime.stopTime(usbAction);
    }
}
