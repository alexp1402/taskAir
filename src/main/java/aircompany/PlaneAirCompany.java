package aircompany;


import fleet.Fleet;
import fleet.PlaneFleet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaneAirCompany implements Company{
    private static final Logger LOG = LoggerFactory.getLogger(PlaneAirCompany.class);

    private Fleet fleet;
    private String companyName;

    public PlaneAirCompany(String companyName, Fleet fleet) {
        this.companyName = companyName;
        this.fleet = fleet;
        LOG.info("PlaneAirCompany created");
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getTotalFleetCargoCapacity(){
        return ((PlaneFleet)fleet).getCargoCapacity();
    }

    public int getTotalFleetPassengerCapacity(){
        return ((PlaneFleet)fleet).getPassengerCapacity();
    }

    public String searchingPlanesByFuelConsumeration(double fuelConsumeration){
        return ((PlaneFleet)fleet).fuelConsumerFromTo(fuelConsumeration,fuelConsumeration);
    }

    public String searchingPlanesByFuelConsumeration(double fuelConsumerationFrom, double fuelConsumerationTo){
        return ((PlaneFleet)fleet).fuelConsumerFromTo(fuelConsumerationFrom,fuelConsumerationTo);
    }

    public void sortingFleetByFlyRange(){
        ((PlaneFleet)fleet).sortByFlyRange();
    }

    public String descriptCompany(){
        StringBuilder description = new StringBuilder();
        description.append("Welcome this is "+getCompanyName()+" Air Company \n");
        description.append(((PlaneFleet)fleet).toString());
        return description.toString();
    }

    public String descriptFleet(){
        return ((PlaneFleet)fleet).toString();
    }

    @Override
    public String toString() {
        return descriptCompany();
    }

}
