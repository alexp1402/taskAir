package fleet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import plane.Plane;

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
            File file =  new File(FleetOperations.getPath() + fileName);
            file.deleteOnExit();
    }
}
