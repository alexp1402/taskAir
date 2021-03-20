package fleet;

import plane.Plane;

import java.io.Serializable;
import java.util.List;

public interface Fleet<T> extends Serializable, FleetOperation<T>, FleetDAO<T> {
    void add(T item);

    void remove(T item);

    void remove(int i);

    int size();

    String getDescription(List<T> collection);

    List<Plane> getFleet();
}
