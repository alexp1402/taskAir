package plane;

import java.util.Objects;

public class Planes {

    public static String getPlaneDescription(Plane plane){
        Objects.requireNonNull(plane,"Plane equal null Something wrong");
        StringBuilder description= new StringBuilder();
        description.append(plane.getClass().getSimpleName()+" plane with bort number: "+plane.getPlaneNumber()+"\n").
                    append("\t passenger capacity = "+plane.getPassengerCapacity()+" peoples \n").
                    append("\t cargo capacity = "+plane.getCargoCapacity()+" tones\n").
                    append("\t fuel consumer = "+plane.getFuelConsumer()+" liters per kilometers\n").
                    append("\t max fly range = "+plane.getFlyRange()+" kilometers\n");
        return description.toString();
    }

    public static String getSmallPlaneDescription(Plane plane){
        Objects.requireNonNull(plane,"Plane equal null Something wrong");
        return " bn: "+plane.getPlaneNumber()
            +" pas=" +plane.getPassengerCapacity()
            +" cargo="+plane.getCargoCapacity()
            +" fuelC="+plane.getFuelConsumer()
            +" flyR="+plane.getFlyRange();
    }
}
