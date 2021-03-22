package com.aircomp.fleet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aircomp.plane.Plane;
import com.aircomp.plane.Planes;

import java.util.ArrayList;
import java.util.List;

public class PlaneFleet implements Fleet<Plane> {

    private static final Logger LOG = LoggerFactory.getLogger(PlaneFleet.class);

    private final List<Plane> fleet;
    private final FleetOperations operations;
    private final FleetDAOImpl fleetDAO;

    public PlaneFleet() {
        fleet = new ArrayList<>();
        operations = new FleetOperations(fleet);
        fleetDAO = new FleetDAOImpl();
        LOG.info("PlaneFleet created");

    }

    @Override
    public void add(Plane plane) {
        fleet.add(plane);
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if ((index >= 0 && (index <= fleet.size() - 1))) {
            fleet.remove(index);
        } else {
            LOG.error("Wrong index. Try to dell non-existing element from fleet fleetSize=" + fleet.size() + " indexIs=" + index);
            throw new IndexOutOfBoundsException("Wrong index. Try to dell non-existing element or fleet");
        }
    }

    @Override
    public void remove(Plane plane) throws IllegalArgumentException {
        if (fleet.contains(plane)) {
            fleet.remove(plane);
        } else {
            LOG.error("Try to dell absent Plane in Fleet");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getCargoCapacity() {
        LOG.info("Calculating Total Cargo Capacity");
        return operations.getCargoCapacity();
    }

    @Override
    public int getPassengerCapacity() {
        LOG.info("Calculating Total Passenger Capacity");
        return operations.getPassengerCapacity();
    }

    @Override
    public void sortByFlyRange() {
        operations.sortByFlyRange();
        LOG.info("Fleet sorting by Fly Range");
    }

    @Override
    public List<Plane> fuelConsumerFromTo(double from, double to) {
        return operations.fuelConsumerFromTo(from, to);
    }

    public String fuelConsumerFromToString(double from, double to) {
        List<Plane> searching = operations.fuelConsumerFromTo(from, to);
        if (searching == null) {
            LOG.info("There are no Plane consider to conditions");
            return "There are no Plane consider to conditions";
        }
        LOG.info("Searching ended. Some plane consider to conditions");
        return getDescription(searching);
    }

    @Override
    public String getDescription(List<Plane> fleet) {
        String description = "";
        if (fleet != null) {
            description += "Fleet size is " + fleet.size() + " planes. It consist from: \n";
            StringBuilder str = new StringBuilder(description);
            for (Plane plane : fleet) {
                str.append(Planes.getPlaneDescription(plane)).append("\n");
            }
            description = str.toString();
        } else {
            return "Fleet isn't created yet";
        }
        return description;
    }

    @Override
    public int size() {
        return fleet.size();
    }

    @Override
    public void save(Fleet<Plane> fleet, String fileName) {
        fleetDAO.save(fleet, fileName);
    }

    @Override
    public Fleet<Plane> load(String fileName) {
        return fleetDAO.load(fileName);
    }

    @Override
    public List<Plane> getFleet() {
        return fleet;
    }

    @Override
    public String toString() {
        return getDescription(fleet);
    }
}
