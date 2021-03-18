package fleet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.Plane;
import plane.Planes;

import java.util.ArrayList;
import java.util.List;

public class PlaneFleet implements Fleet<Plane>{

    private static Logger LOG = LoggerFactory.getLogger(PlaneFleet.class);

    private List<Plane> fleet;
    private FleetOperations operations;

    public PlaneFleet() {
        fleet = new ArrayList<>();
        operations = new FleetOperations(fleet);
        LOG.info("PlaneFleet created");

    }

    public void add(Plane plane){
        fleet.add(plane);
    }

    public void remove(int index) throws IndexOutOfBoundsException{
        if ((index>=0 && (index<= fleet.size()-1))) {
            fleet.remove(index);
        }else{
            LOG.error("Wrong index. Try to dell non-existing element from fleet fleetSize="+fleet.size()+" indexIs="+index);
            throw new IndexOutOfBoundsException("Wrong index. Try to dell non-existing element or fleet");
        }
    }

    public void remove(Plane plane) throws IllegalArgumentException{
        if(fleet.contains(plane)){
            fleet.remove(plane);
        }else{
            LOG.error("Try to dell absent Plane in Fleet");
            throw new IllegalArgumentException();
        }
    }

    public double getCargoCapacity(){
        LOG.info("Calculating Total Cargo Capacity");
        return operations.cargoCapacity();
    }

    public int getPassengerCapacity(){
        LOG.info("Calculating Total Passenger Capacity");
        return operations.passengerCapacity();
    }

    public void sortByFlyRange(){
        operations.sortByFlyRange();
        LOG.info("Fleet sorting by Fly Range");
    }

    public String fuelConsumerFromTo(double  from, double to){
        List<Plane> searching = operations.fuelConsumerFromTo(from,to);
        if (searching == null){
            LOG.info("There are no Plane consider to conditions");
            return "There are no Plane consider to conditions";
        }
        LOG.info("Searching ended. Some plane consider to conditions");
        return getDescription(searching);
   }

    public String getDescription(List<Plane> fleet){
        StringBuilder description = new StringBuilder();
        if(fleet!=null) {
            description.append("Fleet size is "+fleet.size()+" planes. It consist from: \n");
            for (Plane plane : fleet) {
                description.append(Planes.getPlaneDescription(plane)+"\n");
            }
        }else{
            return "Fleet isn't created yet";
        }
        return description.toString();
    }

    @Override
    public String toString() {
        return getDescription(fleet);
    }
}
