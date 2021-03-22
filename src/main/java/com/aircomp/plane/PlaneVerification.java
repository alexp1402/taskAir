package com.aircomp.plane;

public class PlaneVerification {
    public static boolean verifyFuelConsumer(double fuelConsumer) {
        return !(fuelConsumer <= 0);
    }

    public static boolean verifyFlyRange(double flyRange) {
        return !(flyRange <= 0);
    }

    public static boolean verifyPassengerCapacity(int passengerCapacity) {
        return (passengerCapacity >= 0);
    }

    public static boolean verifyCargoCapacity(double cargoCapacity) {
        return !(cargoCapacity < 0);
    }

    public static String verifyPlaneArguments(final String planeNumber, final int passengerCapacity,
                                              final double cargoCapacity, final double fuelConsumer, final double flyRange) {
        String answer = "";

        if (!PlaneVerification.verifyPassengerCapacity(passengerCapacity)) {
            answer += " Passenger capacity must be positive but equal " + passengerCapacity;
        }

        if (!PlaneVerification.verifyCargoCapacity(cargoCapacity)) {
            answer += " Cargo capacity must be positive but equal " + cargoCapacity;
        }

        if (!PlaneVerification.verifyFuelConsumer(fuelConsumer)) {
            answer += "Fuel consumer must be positive but equal " + fuelConsumer;
        }

        if (!PlaneVerification.verifyFlyRange(flyRange)) {
            answer += "Fly range must be positive but equal " + flyRange;
        }

        if (planeNumber == null || planeNumber.length() == 0) {
            answer += "Plane number must be ";
        }

        return answer;
    }
}
