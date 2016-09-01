package example4;

/**
 * Here is an improved version that uses good encapsulation. Notice that the
 * "Startup" class ONLY communicates with, and is only dependent on, the
 * "Car" class. As far as the Startup class is concerned the details of an
 * engine are hidden by the Car. That's another example of encapsulation. Hide
 * unnecessary or inappropriate details from the host class.
 *
 * This also reduces dependencies from 2 to 1. Fewer dependencies make for greater
 * flexibility.
 *
 * @author jlombardo
 */
public class Startup {
    // No magic numbers!! Always use constants
    private static int SIX_CYLINDERS = 6;

    public static void main(String[] args) {

        // Simple!!! Compare this to example3.
        Car car = new Car(SIX_CYLINDERS);
        car.start();

        System.out.println("Car running status: " + car.isRunning());
        System.out.println("Engine Type: " + car.getEngineType());
    }
}
