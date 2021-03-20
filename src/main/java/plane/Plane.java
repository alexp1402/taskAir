package plane;

import java.io.Serializable;

public interface Plane extends Serializable {
    double getFuelConsumer();

    double getFlyRange();

    String getPlaneNumber();

    int getPassengerCapacity();

    double getCargoCapacity();
}
