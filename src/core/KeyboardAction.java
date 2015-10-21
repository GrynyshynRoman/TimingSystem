package core;

/**
 * Created by andre on 21.10.2015.
 */
public class KeyboardAction implements Action {
    @Override
    public void start() {
        System.out.println("We are in KeyboardAction in start");
    }

    @Override
    public void stop() {
        System.out.println("We are in KeyboardAction stop method");
    }
}
