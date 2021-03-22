package com.aircomp.plane;

import com.aircomp.plane.PassengerPlane;
import com.aircomp.plane.Plane;
import com.aircomp.plane.Planes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PlanesTest {

    static Plane plane;

    @BeforeAll
    static void createPlaneMock(){
        plane = mock(PassengerPlane.class);
        when(plane.getCargoCapacity()).thenReturn(1.0);
        when(plane.getPlaneNumber()).thenReturn("Passenger plane");
        when(plane.getFuelConsumer()).thenReturn(1.0);
        when(plane.getFlyRange()).thenReturn(1.0);
        when(plane.getPassengerCapacity()).thenReturn(1);
    }

    @Test
    void getPlaneDescriptionNull(){
       Assertions.assertThrows(NullPointerException.class, ()-> Planes.getPlaneDescription(null));
    }

    @Test
    void getPlaneDescriptionGood(){
        String waitingFor = plane.getClass().getSimpleName()+" plane with bort number: Passenger plane" +
                "\n\t passenger capacity = 1 peoples " +
                "\n\t cargo capacity = 1.0 tones" +
                "\n\t fuel consumer = 1.0 liters per kilometers" +
                "\n\t max fly range = 1.0 kilometers\n";
        Assertions.assertEquals(waitingFor,Planes.getPlaneDescription(plane));
        verify(plane,times(1)).getCargoCapacity();
        verify(plane,times(1)).getPlaneNumber();
        verify(plane,times(1)).getFuelConsumer();
        verify(plane,times(1)).getFlyRange();
        verify(plane,times(1)).getPassengerCapacity();
    }

    @Test
    void getSmallPlaneDescriptionGood(){
        String waitingFor = " bn: Passenger plane pas=1 cargo=1.0 fuelC=1.0 flyR=1.0";
        Assertions.assertEquals(waitingFor,Planes.getSmallPlaneDescription(plane));
    }
}
