package plane;

public interface Plane {
    public double getFuelConsumer();
//    public void setFuelConsumer(double fuelConsumer) throws IllegalArgumentException;
    public double getFlyRange();
//    public void setFlyRange(double flyRange) throws IllegalArgumentException;
//    public void setPlaneNumber(String planeNumber);
    public String getPlaneNumber();
//    public void setPassengerCapacity(int passengerCapacity) throws IllegalArgumentException;
    public int getPassengerCapacity();
//    public void setCargoCapacity(double cargoCapacity) throws IllegalArgumentException;
    public double getCargoCapacity();
}
