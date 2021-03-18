package plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CargoPlane extends Plane {
    private static Logger LOG = LoggerFactory.getLogger(CargoPlane.class);

    public CargoPlane(String planeNumber, int passengerCapacity, double cargoCapacity, double fuelConsumer, double flyRange) {
        try{
            setPlaneNumber(planeNumber);
            setPassengerCapacity(passengerCapacity);
            setCargoCapacity(cargoCapacity);
            setFuelConsumer(fuelConsumer);
            setFlyRange(flyRange);
        }catch (IllegalArgumentException e){
            LOG.error("Error during creating Cargo Plane - "+e.getMessage(),e);
        }
        LOG.info("CargoPlane created bortNumber="+planeNumber);
    }

    @Override
    public String getDescription() {
        StringBuilder description= new StringBuilder("Cargo ");
        description.append(super.getDescription());
        return description.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
