package aircompany;


import fleet.Fleet;
import fleet.PlaneFleet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.Plane;

public class PlaneAirCompany implements Company {
    private static final Logger LOG = LoggerFactory.getLogger(PlaneAirCompany.class);

    private Fleet<Plane> fleet;
    private String companyName;

    public PlaneAirCompany(String companyName, Fleet<Plane> fleet) {
        this.companyName = companyName;
        this.fleet = fleet;
        LOG.info("PlaneAirCompany created");
    }

    @Override
    public void setFleet(Fleet<Plane> fleet) {
        this.fleet = fleet;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public double getTotalFleetCargoCapacity() {
        return fleet.getCargoCapacity();
    }

    @Override
    public int getTotalFleetPassengerCapacity() {
        return fleet.getPassengerCapacity();
    }

    @Override
    public String searchingPlanesByFuelConsumeration(double fuelConsumeration) {
        return ((PlaneFleet) fleet).fuelConsumerFromToString(fuelConsumeration, fuelConsumeration);
    }

    @Override
    public String searchingPlanesByFuelConsumeration(double fuelConsumerationFrom, double fuelConsumerationTo) {
        return ((PlaneFleet) fleet).fuelConsumerFromToString(fuelConsumerationFrom, fuelConsumerationTo);
    }

    @Override
    public void sortingFleetByFlyRange() {
        fleet.sortByFlyRange();
    }

    @Override
    public String descriptCompany() {
        return "Welcome this is " + getCompanyName() + " Air Company \n" + fleet.toString();
    }

    @Override
    public String descriptFleet() {
        return fleet.toString();
    }

    @Override
    public String toString() {
        return descriptCompany();
    }

}
