import aircompany.PlaneAirCompany;
import fleet.PlaneFleet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plane.CargoPlane;
import plane.PassengerPlane;
import plane.Plane;


public class App {
    private static Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        //LOG.error("TESTING");
        //to the test
        //init some plane
        Plane plane1 = new CargoPlane("CAR3355",0,2552.25d,25.2d,1500.25d);
        Plane plane2 = new CargoPlane("CAR2154",0,3125.25d,31.45d,1277.25d);
        Plane plane3 = new PassengerPlane("PAS1402",89,45.41d,9.81d,2100.25d);
        Plane plane4 = new PassengerPlane("PAS5418",324,215.31d,21.78d,1825.25d);
        Plane plane5 = new PassengerPlane("PAS1234",114,61.127d,12.54d,1921.25d);
        //init fleet
        PlaneFleet fleet = new PlaneFleet();
        fleet.add(plane1);
        fleet.add(plane2);
        fleet.add(plane3);
        fleet.add(plane4);
        fleet.add(plane5);
        ////////System.out.println(fleet.getDescription());
        //init company
        PlaneAirCompany company = new PlaneAirCompany("FlyWings",fleet);

        //Testing
        System.out.println(company.toString());
    }
}
