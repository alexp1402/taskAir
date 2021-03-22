package com.aircomp.fleet;

import com.aircomp.fleet.Fleet;
import com.aircomp.fleet.FleetDAOImpl;
import com.aircomp.fleet.PlaneFleet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.aircomp.plane.Plane;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FleetTest {

    static Fleet<Plane> testFleet;
    static String fileName="saveloadTest_dell.txt";

    @BeforeAll
    static void initTestFleet(){
        testFleet = mock(PlaneFleet.class, withSettings().serializable());
        when(testFleet.getDescription(any())).thenReturn("PlaneFleet to test save load");
    }

    @Test
    void saveloadFleet(){
        Fleet<Plane> fleet = new PlaneFleet();
        fleet.save(testFleet,fileName);
        assertEquals(testFleet.getDescription(anyList()), (fleet.load(fileName)).getDescription(anyList()));
    }

    @AfterAll
    static void cleareFile(){
            File file =  new File(new FleetDAOImpl().getPath() + fileName);
            file.deleteOnExit();
    }
}
