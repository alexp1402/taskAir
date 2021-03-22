package com.aircomp.fleet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aircomp.plane.Plane;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

class FleetOperations implements FleetOperation<Plane>, Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(FleetOperations.class);
    private final List<Plane> fleet;

    public FleetOperations(List<Plane> fleet) {
        if (fleet != null) {
            this.fleet = fleet;
        } else {
            LOG.error("Fleet is null");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getPassengerCapacity() {
        int capacity = 0;
        for (Plane plane : fleet) {
            capacity = capacity + plane.getPassengerCapacity();
        }
        return capacity;
    }

    @Override
    public double getCargoCapacity() {
        BigDecimal capacity = BigDecimal.ZERO;
        for (Plane plane : fleet) {
            capacity = capacity.add(BigDecimal.valueOf(plane.getCargoCapacity()));
        }
        return capacity.doubleValue();
    }

    @Override
    public void sortByFlyRange() {
        Collections.sort(fleet, (Plane p1, Plane p2) -> (Double.compare(p1.getFlyRange(), p2.getFlyRange())));
    }

    @Override
    public List<Plane> fuelConsumerFromTo(double from, double to) {
        List<Plane> searchingPlanes = new ArrayList<>();
        if (from <= 0 || to <= 0) {
            LOG.error("Fuel consumer indicator(s) must be greater then zero But from=" + from + " and to=" + to);
            throw new IllegalArgumentException("Fuel consumer indicator(s) must be greater then zero");
        }
        if (from > to) {
            double tmps = to;
            to = from;
            from = tmps;
        }
        for (Plane plane : fleet) {
            if ((plane.getFuelConsumer() >= from) && (plane.getFuelConsumer() <= to)) {
                searchingPlanes.add(plane);
            }
        }
        if (searchingPlanes.size() == 0) return null;
        return searchingPlanes;
    }
}
