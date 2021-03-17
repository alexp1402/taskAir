package plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CargoPlane extends Plane{
    private static Logger LOG = LoggerFactory.getLogger(CargoPlane.class);

    public CargoPlane(String planeNumber, int passengerCapacity, double cargoCapacity, double fuelConsumer, double flyRange) {
        super(planeNumber, 0, cargoCapacity, fuelConsumer, flyRange);
        LOG.info("CargoPlane created bortNumber="+planeNumber);
    }

    @Override
    public void fly() {
        //STUB
        LOG.info("Plane bortNumber="+this.getPlaneNumber()+" fly");
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
