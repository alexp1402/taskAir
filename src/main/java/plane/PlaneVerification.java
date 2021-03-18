package plane;

public class PlaneVerification {
    public static boolean verifyFuelConsumer (double fuelConsumer){
        return (fuelConsumer<=0) ? false : true;
        }

    public static boolean verifyFlyRange(double flyRange){
        return (flyRange<=0) ? false : true;
    }

    public static boolean verifyPassengerCapacity(int passengerCapacity){
        return (passengerCapacity<0) ? false : true;
    }

    public static boolean verifyCargoCapacity(double cargoCapacity) {
        return (cargoCapacity<0) ? false : true;
    }
}
