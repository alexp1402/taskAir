package fleet;

import java.util.List;

public interface Fleet<T>{
    public void add(T item);
    public void remove(T item);
    public String getDescription();
}
