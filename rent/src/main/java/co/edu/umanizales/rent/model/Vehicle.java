package co.edu.umanizales.rent.model;

public class Vehicle {
    private String plateNumber;
    private String type;
    private String color;
    private boolean available;

    public Vehicle(String plateNumber, String type, String color, boolean available) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
