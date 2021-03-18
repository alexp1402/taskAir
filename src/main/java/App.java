import aircompany.PlaneAirCompany;
import fleet.Fleet;
import fleet.PlaneFleet;
import plane.CargoPlane;
import plane.Plane;
import plane.PassengerPlane;


public class App {


    public static void main(String[] args) {
        //LOG.error("TESTING");
        //to the test
        //init some plane
        Plane plane1 = new CargoPlane("CAR3355",200.20d,10.5d,1200.50d);
        Plane plane2 = new CargoPlane("CAR2154",300.30d,11.2d,1100.10d);
        Plane plane3 = new PassengerPlane("PAS1402",100,10.10d,4.4d,2200);
        Plane plane4 = new PassengerPlane("PAS5418",300,30.30d,10.7d,1350.50d);
        Plane plane5 = new PassengerPlane("PAS1234",200,20.20d,6.5d,1600.25d);
        //init fleet
        Fleet<Plane> fleet = new PlaneFleet();
        fleet.add(plane1);
        fleet.add(plane2);
        fleet.add(plane3);
        fleet.add(plane4);
        fleet.add(plane5);

        //init company
        PlaneAirCompany company = new PlaneAirCompany("FlyWings",fleet);

        //Testing

        System.out.println("Fleet total cargo capacity = "+company.getTotalFleetCargoCapacity());
        System.out.println("Fleet total passenger capacity = "+company.getTotalFleetPassengerCapacity());
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Searching Plane with fuel consumerationes (9.81d) :\n"+company.searchingPlanesByFuelConsumeration(9.81d));
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Searching Plane with fuel consumerationes (9.00d - 22.00d) :\n"+company.searchingPlanesByFuelConsumeration(9 ,22)+"\n");
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Sorting BY Fly Range");
        company.sortingFleetByFlyRange();
        System.out.println(company.descriptFleet());
    }
}
