package plane;

public abstract class Plane implements Flyable {
    private String planeNumber;
    private int passengerCapacity;
    private double cargoCapacity;
    private double fuelConsumer;
    private double flyRange;

    public Plane(String planeNumber, int passengerCapacity, double cargoCapacity, double fuelConsumer, double flyRange) {
        this.planeNumber = planeNumber;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.fuelConsumer = fuelConsumer;
        this.flyRange = flyRange;
    }

    public double getFuelConsumer() {
        return fuelConsumer;
    }

    public void setFuelConsumer(double fuelConsumer) {
        this.fuelConsumer = fuelConsumer;
    }

    public double getFlyRange() {
        return flyRange;
    }

    public void setFlyRange(double flyRange) {
        this.flyRange = flyRange;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public String getDescription(){
        StringBuilder description= new StringBuilder();
        description.append("plane with bort number: "+getPlaneNumber()+"\n");
        description.append("\t passenger capacity = "+getPassengerCapacity()+" people \n");
        description.append("\t cargo capacity = "+getCargoCapacity()+" tone\n");
        description.append("\t fuel consumer = "+getFuelConsumer()+" liters per kilometers\n");
        description.append("\t max fly range = "+getFlyRange()+" kilometers\n");
        return description.toString();
    };
}
