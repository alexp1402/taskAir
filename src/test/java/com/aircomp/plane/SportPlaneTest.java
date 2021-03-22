package com.aircomp.plane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SportPlaneTest {

    public static Stream<Arguments> argumentsForNewSPlane() {
        return Stream.of(
                Arguments.of("A", -1, 1.0),
                Arguments.of("B", 1, -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForNewSPlane")
    void createWrongSportPlaneObject(String name, double fuelC, double flyR) {
        Assertions.assertThrows(IllegalArgumentException.class, ()->new SportPlane(name,fuelC,flyR));
    }

    @Test
    void createRightSportPlaneNotNull(){
        Plane cPlane;
        cPlane = new SportPlane("AAA",1.0,2.0);
        Assertions.assertNotNull(cPlane);
    }

    @Test
    void createRightSportDontThrow(){
        Assertions.assertDoesNotThrow(()->{new SportPlane("AAA",1.0,2.0);});
    }
}
