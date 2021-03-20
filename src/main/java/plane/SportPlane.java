package plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SportPlane implements Plane {
    private static final Logger LOG = LoggerFactory.getLogger(SportPlane.class);
    private final String planeNumber;
    private final int passengerCapacity = 0;
    private final double cargoCapacity = 0;
    private final double fuelConsumer;
    private final double flyRange;

    public SportPlane(String planeNumber, double fuelConsumer, double flyRange) {

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

        LOG.info("CargoPlane created " + Planes.getSmallPlaneDescription(this));
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
        return 0;
    }

    @Override
    public double getCargoCapacity() {
        return 0;
    }
}
