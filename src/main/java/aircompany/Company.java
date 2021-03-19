package aircompany;

import fleet.Fleet;
import plane.Plane;

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
