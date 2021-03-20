package plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PassengerPlane implements Plane {
    private static final Logger LOG = LoggerFactory.getLogger(PassengerPlane.class);

    private final String planeNumber;
    private final int passengerCapacity;
    private final double cargoCapacity;
    private final double fuelConsumer;
    private final double flyRange;

    public PassengerPlane(String planeNumber, int passengerCapacity, double cargoCapacity, double fuelConsumer, double flyRange) {

        if (PlaneVerification.verifyPassengerCapacity(passengerCapacity)) {
            this.passengerCapacity = passengerCapacity;
        } else {
            LOG.error("Passenger capacity must be positive but equal " + passengerCapacity);
            throw new IllegalArgumentException("Cargo capacity must be positive but is" + passengerCapacity);
        }

        if (PlaneVerification.verifyCargoCapacity(cargoCapacity)) {
            this.cargoCapacity = cargoCapacity;
        } else {
            LOG.error("Cargo capacity must be positive but equal " + cargoCapacity);
            throw new IllegalArgumentException("Cargo capacity must be positive but is" + cargoCapacity);
        }

        if (PlaneVerification.verifyFuelConsumer(fuelConsumer)) {
            this.fuelConsumer = fuelConsumer;
        } else {
            LOG.error("Fuel consumer must be positive but equal " + fuelConsumer);
            throw new IllegalArgumentException("Fuel consumer must be positive but equal" + fuelConsumer);
        }

        if (PlaneVerification.verifyFlyRange(flyRange)) {
            this.flyRange = flyRange;
        } else {
            LOG.error("Fly range must be positive but equal " + flyRange);
            throw new IllegalArgumentException("Fly range must be positive but equal " + flyRange);
        }

        this.planeNumber = planeNumber;

        LOG.info("PassengerPlane created " + Planes.getSmallPlaneDescription(this));
    }

    @Override
    public double getFuelConsumer() {
        return fuelConsumer;
    }

    @Override
    public double getFlyRange() {
        return flyRange;
    }

    @Override
    public String getPlaneNumber() {
        return planeNumber;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return Planes.getSmallPlaneDescription(this);
    }
}
