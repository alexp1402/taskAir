package plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PassengerPlane extends Plane{

    private static Logger LOG = LoggerFactory.getLogger(PassengerPlane.class);

    public PassengerPlane(String planeNumber, int passengerCapacity, double cargoCapacity, double fuelConsumer, double flyRange) {
        super(planeNumber, passengerCapacity, cargoCapacity, fuelConsumer, flyRange);
        LOG.info("PassengerPlane created bortNumber="+planeNumber);
    }

    @Override
    public void fly() {
        //STUB
        LOG.info("Plane bortNumber="+this.getPlaneNumber()+" fly");
    }

    @Override
    public String getDescription() {
        StringBuilder description= new StringBuilder("Passenger ");
        description.append(super.getDescription());
        return description.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
