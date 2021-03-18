package plane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class CargoPlaneTest {
    CargoPlane plane = new CargoPlane();

    private Stream<Arguments> constructDataBadArgument() {
        return Stream.of(
                Arguments.of("A", -5,5,6),
                Arguments.of("B", 5,-5,6),
                Arguments.of("C",  5,5,-6)
        );
    }

    @ParameterizedTest
   
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
