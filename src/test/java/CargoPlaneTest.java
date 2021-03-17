import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import plane.CargoPlane;

import static org.junit.jupiter.api.Assertions.*;

public class CargoPlaneTest {
    @Test
    @DisplayName("Creating CargoPlane")
    void CargoPlaneCreateTest(){
        CargoPlane plane = null;
        plane = new CargoPlane("CAR3355",0,2552.25d,25.2d,1500.25d);
        assertNotNull(plane);
    }
}
