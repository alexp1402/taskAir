package plane;

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
       Assertions.assertThrows(NullPointerException.class, ()->Planes.getPlaneDescription(null));
    }

    @Test
    void getPlaneDescriptionGood(){
        System.out.println(Planes.getPlaneDescription(plane));
        Assertions.assertNotNull(Planes.getPlaneDescription(plane));
    }

    @Test
    void getSmallPlaneDescriptionGood(){
        System.out.println(Planes.getPlaneDescription(plane));
        Assertions.assertNotNull(Planes.getPlaneDescription(plane));
    }
}
