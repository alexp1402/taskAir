package plane;

public class Planes {
    public static String getPlaneDescription(Plane plane){
        StringBuilder description= new StringBuilder();
        description.append(plane.getClass().getSimpleName()+" plane with bort number: "+plane.getPlaneNumber()+"\n").
                    append("\t passenger capacity = "+plane.getPassengerCapacity()+" people \n").
                    append("\t cargo capacity = "+plane.getCargoCapacity()+" tone\n").
                    append("\t fuel consumer = "+plane.getFuelConsumer()+" liters per kilometers\n").
                    append("\t max fly range = "+plane.getFlyRange()+" kilometers\n");
        return description.toString();
    }
    public static String getSmallPlaneDescription(Plane plane){
        return " bn: "+plane.getPlaneNumber()
            +" pas=" +plane.getPassengerCapacity()
            +" cargo="+plane.getCargoCapacity()
            +" fuelC="+plane.getFuelConsumer()
            +" flyR="+plane.getFlyRange();
    }
}
