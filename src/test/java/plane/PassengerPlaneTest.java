package plane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PassengerPlaneTest {

    public static Stream<Arguments> argumentsForNewPPlane() {
        return Stream.of(
                Arguments.of("A", -1, 1.0, 1.0, 1.0),
                Arguments.of("B", 1, -1.0, 1.0, 1.0),
                Arguments.of("C", 1, 1.0, -1.0, 1.0),
                Arguments.of("D", 1, 1.0, 1.0, -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForNewPPlane")
    void createWrongPassengerPlaneObject(String name, int passC, double cargocC, double fuelC, double flyR) {
        Assertions.assertThrows(IllegalArgumentException.class, ()->new PassengerPlane(name,passC,cargocC,fuelC,flyR));
    }

}
