package co.edu.umanizales.rent.model;

public class Vehicle {
    private String plateNumber;
    private String type; // "Car", "Moto", etc.
    private boolean available;

    public Vehicle(String plateNumber, String type, boolean available) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.available = available;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
