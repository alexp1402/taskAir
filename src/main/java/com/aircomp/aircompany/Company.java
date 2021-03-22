package com.aircomp.aircompany;

import com.aircomp.fleet.Fleet;
import com.aircomp.plane.Plane;

public interface Company {
    void setFleet(Fleet<Plane> fleet);

    String getCompanyName();

    void setCompanyName(String companyName);

    double getTotalFleetCargoCapacity();

    int getTotalFleetPassengerCapacity();

    String searchingPlanesByFuelConsumeration(double fuelConsumeration);

    String searchingPlanesByFuelConsumeration(double fuelConsumerationFrom, double fuelConsumerationTo);

    void sortingFleetByFlyRange();

    String descriptCompany();

    String descriptFleet();

}
