package plane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CargoPlaneTest {

    CargoPlane cPlane = new CargoPlane("CAR3355",2552.25d,25.2d,1500.25d);

    @Test

    @DisplayName("Illegal argument Passenger Capacity")
    void CargoPlaneIllegalArgumentPasCapacityTest(){
       // assertThrows(IllegalArgumentException.class,()->{cPlane.setPassengerCapacity(-10);});
    }

    @Test
    void CargoPlaneIllegalArgumentCargoCapacityTest(){
       // assertThrows(IllegalArgumentException.class,()->{cPlane.setCargoCapacity(-10);});
    }

}
