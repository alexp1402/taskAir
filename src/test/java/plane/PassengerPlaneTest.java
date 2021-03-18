package plane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PassengerPlaneTest {
    @Test
    @DisplayName("Create PassengerPlane test")
    void PassengerPlaneCreateTest(){
        Plane plane = null;
        plane = new PassengerPlane("PAS1234",114,61.127d,12.54d,1921.25d);
        assertNotNull(plane);
    }

}
