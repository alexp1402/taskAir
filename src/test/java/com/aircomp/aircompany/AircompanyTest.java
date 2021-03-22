package com.aircomp.aircompany;

import com.aircomp.fleet.Fleet;
import com.aircomp.fleet.PlaneFleet;
import com.aircomp.plane.Plane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AircompanyTest {

    @Test
    void runFullAppFromFile(){
        Fleet<Plane> fleet = new PlaneFleet();
        fleet = fleet.load("2Car3Pas1Sport.txt");
        PlaneAirCompany company = new PlaneAirCompany("FlyWing",fleet);
        double cargo = company.getTotalFleetCargoCapacity();
        Assertions.assertEquals(561.1d, cargo);
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Task 1. Fleet total cargo capacity = "+cargo);
        double passenger = company.getTotalFleetPassengerCapacity();
        Assertions.assertEquals(600, passenger);
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Task 2. Fleet total passenger capacity = "+passenger);
        System.out.println("///////////////////////////////////////////////");
        String search = company.searchingPlanesByFuelConsumeration(10.7d);
        Assertions.assertNotEquals("There are no Plane consider to conditions", search);
        System.out.println("Task 4. Searching Plane with fuel consumerationes (10.7d) :\n"+search);
        System.out.println("///////////////////////////////////////////////");
        search = company.searchingPlanesByFuelConsumeration(9 ,22);
        Assertions.assertNotEquals("There are no Plane consider to conditions",search);
        System.out.println("Task 4. Searching Plane with fuel consumerationes (9.00d - 22.00d) :\n"+search);
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Task 3. Sorting BY Fly Range");
        company.sortingFleetByFlyRange();
        System.out.println(company.descriptFleet());
    }
}
