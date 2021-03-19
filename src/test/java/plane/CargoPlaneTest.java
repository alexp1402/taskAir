package plane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CargoPlaneTest {

    public static Stream<Arguments> argumentsForNewCPlane() {
            return Stream.of(
                    Arguments.of("A",-1.0,1.0,1.0),
                    Arguments.of("B",1.0,-1.0,1.0),
                    Arguments.of("C",1.0,1.0,-1.0)
            );
    }

    @ParameterizedTest
    @MethodSource("argumentsForNewCPlane")
    void createWrongCargoPlaneObject(String name, double capacity, double fuelC, double flyR) {
        Assertions.assertThrows(IllegalArgumentException.class, ()->new CargoPlane(name,capacity,fuelC,flyR));
    }
}
