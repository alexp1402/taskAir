package plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PassengerPlane extends Plane {

    private static Logger LOG = LoggerFactory.getLogger(PassengerPlane.class);

    public PassengerPlane(String planeNumber, int passengerCapacity, double cargoCapacity, double fuelConsumer, double flyRange) {
        try{
            setPlaneNumber(planeNumber);
            setPassengerCapacity(passengerCapacity);
            setCargoCapacity(cargoCapacity);
            setFuelConsumer(fuelConsumer);
            setFlyRange(flyRange);
        }catch (IllegalArgumentException e){
            LOG.error("Error during creating Passenger Plane - "+e.getMessage(),e);
        }
        LOG.info("PassengerPlane created bortNumber="+planeNumber);
    }

    @Override
    public String getDescription() {
        return Planes.getPlaneDescription(this);
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
