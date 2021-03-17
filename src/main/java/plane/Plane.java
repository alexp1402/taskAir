package plane;

public abstract class Plane implements Flyable {
    private String planeNumber;
    private int passengerCapacity;
    private double cargoCapacity;
    private double fuelConsumer;
    private double flyRange;

    public double getFuelConsumer() {
        return fuelConsumer;
    }

    public void setFuelConsumer (double fuelConsumer) throws IllegalArgumentException {
        if(fuelConsumer<=0){
            throw new IllegalArgumentException("fuel consumer must be greater than zero");
        }else{
            this.fuelConsumer = fuelConsumer;
        }
    }

    public double getFlyRange() {
        return flyRange;
    }

    public void setFlyRange(double flyRange) throws IllegalArgumentException{
        if(flyRange <=0) {
            throw new IllegalArgumentException("fly range (area) must be greater then zero");
        }else{
            this.flyRange = flyRange;
        }
    }

    public void setPlaneNumber(String planeNumber){
        this.planeNumber = planeNumber;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPassengerCapacity(int passengerCapacity) throws IllegalArgumentException{
        if (passengerCapacity<0) {
            throw new IllegalArgumentException("passenger Capacity must be positive or zero");
        }else{
            this.passengerCapacity = passengerCapacity;
        }
    }

    public void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity<0) {
            throw new IllegalArgumentException("cargo Capacity must be positive or zero");
        }else{
            this.cargoCapacity = cargoCapacity;
        }
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
