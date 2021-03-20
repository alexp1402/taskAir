package plane;

import java.util.Objects;

public class Planes {

    public static String getPlaneDescription(Plane plane) {
        Objects.requireNonNull(plane, "Plane equal null Something wrong");
        return plane.getClass().getSimpleName() + " plane with bort number: " + plane.getPlaneNumber() + "\n" +
                "\t passenger capacity = " + plane.getPassengerCapacity() + " peoples \n" +
                "\t cargo capacity = " + plane.getCargoCapacity() + " tones\n" +
                "\t fuel consumer = " + plane.getFuelConsumer() + " liters per kilometers\n" +
                "\t max fly range = " + plane.getFlyRange() + " kilometers\n";

    }

    public static String getSmallPlaneDescription(Plane plane) {
        Objects.requireNonNull(plane, "Plane equal null Something wrong");
        return " bn: " + plane.getPlaneNumber()
                + " pas=" + plane.getPassengerCapacity()
                + " cargo=" + plane.getCargoCapacity()
                + " fuelC=" + plane.getFuelConsumer()
                + " flyR=" + plane.getFlyRange();
    }
}
