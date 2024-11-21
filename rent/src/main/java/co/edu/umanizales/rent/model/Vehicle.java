package co.edu.umanizales.rent.model;

public class Vehicle {
    private String plateNumber;
    private String type;
    private boolean available;
    private String color;

    public Vehicle(String plateNumber, String type, boolean available, String color) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.available = available;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
