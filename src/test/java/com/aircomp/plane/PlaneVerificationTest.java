package com.aircomp.plane;

import com.aircomp.plane.PlaneVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaneVerificationTest {

    @Test
    void returnFalseWhenFuelConsumerLessZero(){
        Assertions.assertFalse(PlaneVerification.verifyFuelConsumer(-1.0));
    }

    @Test
    void returnFalseWhenFlyRangeLessZero(){
        Assertions.assertFalse(PlaneVerification.verifyFlyRange(-1.0));
    }

    @Test
    void returnFalseWhenCargoLessZero(){
        Assertions.assertFalse(PlaneVerification.verifyCargoCapacity(-1.0));
    }

    @Test
    void returnFalseWhenPassengerCapacityLessZero(){
        Assertions.assertFalse(PlaneVerification.verifyPassengerCapacity(-1));
    }
}
