package fleet;

import plane.Plane;

import java.util.List;

public interface FleetOperation<T> {

    int getPassengerCapacity();

    double getCargoCapacity();

    void sortByFlyRange();

    List<T> fuelConsumerFromTo(double from, double to);

}
