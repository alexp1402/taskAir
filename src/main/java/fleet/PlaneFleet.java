package fleet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.Flyable;
import plane.Plane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaneFleet implements Fleet<Flyable>{

    private static Logger LOG = LoggerFactory.getLogger(PlaneFleet.class);

    private List<Flyable> fleet;

    public PlaneFleet() {
        fleet = new ArrayList<>();
        LOG.info("PlaneFleet created");
    }

    public void add(Flyable plane){
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

    public void remove(Flyable plane) throws IllegalArgumentException{
        if(fleet.contains(plane)){
            fleet.remove(plane);
        }else{
            LOG.error("Try to dell absent Plane in Fleet");
            throw new IllegalArgumentException();
        }
    }

    public String getDescription(){
        StringBuilder description = new StringBuilder();
        if(fleet!=null) {
            description.append("Fleet size is "+fleet.size()+" plane.\nIt consist from: \n");
            for (Flyable plane : fleet) {
                description.append(((Plane)plane).getDescription()+"\n");
            }
        }else{
            return "Fleet has no one plane in. First add some plane";
        }
        return description.toString();
    }

    @Override
    public Iterator<Flyable> iterator() {
        return fleet.iterator();
    }

    @Override
    public List<Flyable> getFleetAsList() {
        return fleet;
    }
}
