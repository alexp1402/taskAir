package com.aircomp.plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CargoPlane implements Plane {
    private static final Logger LOG = LoggerFactory.getLogger(CargoPlane.class);
    private final String planeNumber;
    private final int passengerCapacity = 0;
    private final double cargoCapacity;
    private final double fuelConsumer;
    private final double flyRange;

    public CargoPlane(String planeNumber, double cargoCapacity, double fuelConsumer, double flyRange) {

        String msg = PlaneVerification.verifyPlaneArguments(planeNumber, passengerCapacity, cargoCapacity, fuelConsumer, flyRange);

        if (msg.length() == 0) {
            this.planeNumber = planeNumber;
            this.cargoCapacity = cargoCapacity;
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
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return Planes.getSmallPlaneDescription(this);
    }
}
