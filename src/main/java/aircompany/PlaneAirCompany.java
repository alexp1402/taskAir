package aircompany;


import fleet.Fleet;
import fleet.PlaneFleet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.Plane;

public class PlaneAirCompany implements Company{
    private static final Logger LOG = LoggerFactory.getLogger(PlaneAirCompany.class);

    private Fleet<Plane> fleet;
    private String companyName;

    public PlaneAirCompany(String companyName, Fleet<Plane> fleet) {
        this.companyName = companyName;
        this.fleet = fleet;
        LOG.info("PlaneAirCompany created");
    }

    public void setFleet(Fleet<Plane> fleet) {
        this.fleet = fleet;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getTotalFleetCargoCapacity(){
        return fleet.getCargoCapacity();
    }

    public int getTotalFleetPassengerCapacity(){
        return fleet.getPassengerCapacity();
    }

    public String searchingPlanesByFuelConsumeration(double fuelConsumeration){
        return ((PlaneFleet)fleet).fuelConsumerFromToString(fuelConsumeration,fuelConsumeration);
    }

    public String searchingPlanesByFuelConsumeration(double fuelConsumerationFrom, double fuelConsumerationTo){
        return ((PlaneFleet)fleet).fuelConsumerFromToString(fuelConsumerationFrom,fuelConsumerationTo);
    }

    public void sortingFleetByFlyRange(){
        fleet.sortByFlyRange();
    }

    public String descriptCompany(){
        return "Welcome this is "+getCompanyName()+" Air Company \n"+fleet.toString();
    }

    public String descriptFleet(){
        return fleet.toString();
    }

    @Override
    public String toString() {
        return descriptCompany();
    }

}
