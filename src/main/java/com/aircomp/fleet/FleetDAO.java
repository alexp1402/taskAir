package com.aircomp.fleet;

public interface FleetDAO<T> {
    void save(Fleet<T> fleet, String fileName);

    Fleet<T> load(String fileName);
}
