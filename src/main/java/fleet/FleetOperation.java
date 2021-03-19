package fleet;

import plane.Plane;

import java.util.List;

public interface FleetOperation {

    int getPassengerCapacity();

    double getCargoCapacity();

    void sortByFlyRange();

    List<Plane> fuelConsumerFromTo(double from, double to);

    void save(Fleet<Plane> fleet, String fileName);

    Fleet<Plane> load(String fileName);
}
