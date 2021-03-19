package plane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaneVerificationTest {

    @Test
    void returnFalseWhenFuelConsumerLessZero(){
        Assertions.assertEquals(false, PlaneVerification.verifyFuelConsumer(-1.0));
    }

    @Test
    void returnFalseWhenFlyRangeLessZero(){
        Assertions.assertEquals(false, PlaneVerification.verifyFlyRange(-1.0));
    }

    @Test
    void returnFalseWhenCargoLessZero(){
        Assertions.assertEquals(false, PlaneVerification.verifyCargoCapacity(-1.0));
    }

    @Test
    void returnFalseWhenPassengerCapacityLessZero(){
        Assertions.assertEquals(false, PlaneVerification.verifyPassengerCapacity(-1));
    }
}
