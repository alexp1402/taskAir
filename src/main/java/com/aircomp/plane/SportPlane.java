package com.aircomp.plane;

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

        String msg = PlaneVerification.verifyPlaneArguments(planeNumber, passengerCapacity, cargoCapacity, fuelConsumer, flyRange);

        if (msg.length() == 0) {
            this.planeNumber = planeNumber;
            this.fuelConsumer = fuelConsumer;
            this.flyRange = flyRange;
        } else {
            LOG.error("Illegal plane arguments + " + msg);
            throw new IllegalArgumentException("Illegal plane arguments + " + msg);
        }

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
