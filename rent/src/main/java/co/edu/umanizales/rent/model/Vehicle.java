package co.edu.umanizales.rent.model;

import co.edu.umanizales.rent.menu.VehicleType;

public class Vehicle {
    private String plateNumber;
    private String type; // "Car", "Moto", etc.
    private String color;
    private VehicleType vehicleType;
    private boolean available;

    public Vehicle(String plateNumber, String type, String color, VehicleType vehicleType, boolean available) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.color = color;
        this.vehicleType = vehicleType;
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}


