package fleet;

import plane.Plane;

import java.math.BigDecimal;
import java.util.*;

class FleetOperations {

    private List<Plane> fleet;

    public FleetOperations(List<Plane> fleet) {
        if(fleet!=null) {
            this.fleet = fleet;
        }else{
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
            public int compare(Plane o1, Plane o2) {
                return (int)(o1.getFlyRange() - o2.getFlyRange());
            }
        });
    }

    public List<Plane> fuelConsumerFromTo(double from, double to){
        List<Plane> searchingPlanes = new ArrayList<>();
        if(from<=0 || to<=0){
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
