package fleet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.Plane;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

class FleetOperations implements FleetOperation,Serializable {
    private final static String path="src/main/resources/fleet/";
    private final static Logger LOG = LoggerFactory.getLogger(FleetOperations.class);
    private final List<Plane> fleet;

    public FleetOperations(List<Plane> fleet) {
        if(fleet!=null) {
            this.fleet = fleet;
        }else{
            LOG.error("Fleet is null");
            throw new IllegalArgumentException();
        }
    }

    public int getPassengerCapacity(){
        int capacity=0;
        for (Plane plane : fleet) {
            capacity=capacity+plane.getPassengerCapacity();
        }
        return capacity;
    }

    public double getCargoCapacity(){
        BigDecimal capacity = BigDecimal.ZERO;
        for (Plane plane : fleet) {
            capacity = capacity.add(BigDecimal.valueOf(plane.getCargoCapacity()));
        }
        return capacity.doubleValue();
    }

    public void sortByFlyRange(){
        Collections.sort(fleet, (Plane p1,Plane p2)-> ((Double)p1.getFlyRange()).compareTo(p2.getFlyRange()));
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

    public void save(Fleet<Plane> fleet, String fileName) {
        Objects.requireNonNull(fleet,"Fleet is null First create new Fleet");
        try(ObjectOutputStream objOutStr = new ObjectOutputStream(new FileOutputStream(path+fileName)))
        {
            objOutStr.writeObject(fleet);
        }catch(IOException e){
            LOG.error("Saving file Fleet. Couldn't write file from "+path+fileName, e);
        }
    }

    public Fleet<Plane> load(String fileName) {
        
        File f = new File(path+fileName);
        
        if(!f.exists() || f.isDirectory()) {
            LOG.error("Loading file Fleet. Couldn't find file "+path+fileName);
            throw new IllegalArgumentException(fileName);
        }
        
        Fleet<Plane> fleet = null;
        
        try(ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(path+fileName)))
        {
            fleet = (Fleet<Plane>) objInStr.readObject();
        }catch(IOException e){
            LOG.error("Loading fleet Couldn't read file "+path+fileName, e);
        }catch (ClassNotFoundException e){
            LOG.error("Couldn't find class during loading Fleet"+Fleet.class, e);
        }

        return fleet;
    }

    static String getPath(){
        return path;
    }

}
