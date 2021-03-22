package com.aircomp.fleet;

import java.util.List;

public interface FleetOperation<T> {

    int getPassengerCapacity();

    double getCargoCapacity();

    void sortByFlyRange();

    List<T> fuelConsumerFromTo(double from, double to);

}
