package plane;

public class Planes {
    public static String getPlaneDescription(Flyable plane){
        StringBuilder description= new StringBuilder();
        description.append(plane.getClass().getName()+" plane with bort number: "+plane.getPlaneNumber()+"\n").
                    append("\t passenger capacity = "+plane.getPassengerCapacity()+" people \n").
                    append("\t cargo capacity = "+plane.getCargoCapacity()+" tone\n").
                    append("\t fuel consumer = "+plane.getFuelConsumer()+" liters per kilometers\n").
                    append("\t max fly range = "+plane.getFlyRange()+" kilometers\n");
        return description.toString();
    }
}
