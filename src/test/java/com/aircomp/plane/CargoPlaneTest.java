package com.aircomp.plane;

import com.aircomp.plane.CargoPlane;
import com.aircomp.plane.Plane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    void createRightCargoPlaneNotNull(){
        Plane cPlane;
        cPlane = new CargoPlane("AAA",1.0,2.0,3.0);
        Assertions.assertNotNull(cPlane);
    }

    @Test
    void createRightCargoPlaneDontThrow(){
        Assertions.assertDoesNotThrow(()->{new CargoPlane("AAA",1.0,2.0,3.0);});
    }
}
