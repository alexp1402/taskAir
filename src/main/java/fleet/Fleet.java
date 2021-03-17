package fleet;

import java.util.List;

public interface Fleet<T> extends Iterable<T>{
    public void add(T item);
    public void remove(T item);
    public String getDescription();
    public List<T> getFleetAsList();
}
