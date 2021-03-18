package fleet;

import plane.Flyable;
import plane.Plane;

import java.math.BigDecimal;
import java.util.*;

public class FleetOperations {

    private List<Flyable> fleet;

    public FleetOperations(List<Flyable> fleet) {
        if(fleet!=null) {
            this.fleet = fleet;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public int passengerCapacity(){
        int capacity=0;
        for (Flyable plane : fleet) {
            capacity=capacity+((Plane)plane).getPassengerCapacity();
        }
        return capacity;
    }

    public double cargoCapacity(){
        BigDecimal capacity = new BigDecimal(0.0);
        for (Flyable plane : fleet) {
            capacity.add(BigDecimal.valueOf(((Plane)plane).getCargoCapacity()));
        }

        return capacity.doubleValue();
    }

    public void sortByFlyRange(){
        Collections.sort(fleet, new Comparator<Flyable>() {
            @Override
            public int compare(Flyable o1, Flyable o2) {
                return (int)(((Plane)o1).getFlyRange() - ((Plane)o2).getFlyRange());
            }
        });
    }

    public List<Flyable> fuelConsumerFromTo(double from, double to){
        List<Flyable> searchingPlanes = new ArrayList<>();
        if(from<=0 || to<=0){
            throw new IllegalArgumentException("Fuel consumer indicator(s) must be greater then zero");
        }
        if (from>to) {
            double tmps=to;
            to=from;
            from=tmps;
        }
        for(Object plane: fleet){
            if((((Plane)plane).getFuelConsumer()>=from) && (((Plane)plane).getFuelConsumer()<=to)){
                searchingPlanes.add((Plane) plane);
            }
        }
        if(searchingPlanes.size()==0) return null;
        return searchingPlanes;
    }

}
