package aircompany;


import fleet.Fleet;
import fleet.PlaneFleet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.Flyable;

import java.util.List;

public class PlaneAirCompany implements Company{
    private static final Logger LOG = LoggerFactory.getLogger(PlaneAirCompany.class);

    public Fleet fleet;
    private String companyName;

    public PlaneAirCompany(String companyName, Fleet fleet) {
        this.companyName = companyName;
        this.fleet = fleet;
        LOG.info("PlaneAirCompany created");
    }

    public PlaneAirCompany(String companyName) {
        this.companyName = companyName;
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

    public String descriptCompany(){
        StringBuilder description = new StringBuilder();
        description.append("Welcome this is "+getCompanyName()+" Air Company \n");
        description.append(((PlaneFleet)fleet).getDescription());
        return description.toString();
    }

    @Override
    public String toString() {
        return descriptCompany();
    }

}
