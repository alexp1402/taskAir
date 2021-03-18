package fleet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.Plane;

import java.math.BigDecimal;
import java.util.*;

class FleetOperations {
    private final static Logger LOG = LoggerFactory.getLogger(FleetOperations.class);
    private List<Plane> fleet;

    public FleetOperations(List<Plane> fleet) {
        if(fleet!=null) {
            this.fleet = fleet;
        }else{
            LOG.error("Fleet is null");
            throw new IllegalArgumentException();
        }
    }

    public int passengerCapacity(){
        int capacity=0;
        for (Plane plane : fleet) {
            capacity=capacity+plane.getPassengerCapacity();
        }
        return capacity;
    }

    public double cargoCapacity(){
        BigDecimal capacity = new BigDecimal(0.0);
        for (Plane plane : fleet) {
            capacity = capacity.add(BigDecimal.valueOf(plane.getCargoCapacity()));
        }
        return capacity.doubleValue();
    }

    public void sortByFlyRange(){
        Collections.sort(fleet, new Comparator<Plane>() {
            @Override
            public int compare(Plane p1, Plane p2) {
                return (int)(p1.getFlyRange() - p2.getFlyRange());
            }
        });
    }

    public List<Plane> fuelConsumerFromTo(double from, double to){
        List<Plane> searchingPlanes = new ArrayList<>();
        if(from<=0 || to<=0){
            LOG.error("Fuel consumer indicator(s) must be greater then zero But from="+from+" and to="+to);
            throw new IllegalArgumentException("Fuel consumer indicator(s) must be greater then zero");
        }
        if (from>to) {
            double tmps=to;
            to=from;
            from=tmps;
        }
        for(Plane plane: fleet){
            if((plane.getFuelConsumer()>=from) && (plane.getFuelConsumer()<=to)){
                searchingPlanes.add(plane);
            }
        }
        if(searchingPlanes.size()==0) return null;
        return searchingPlanes;
    }

}
