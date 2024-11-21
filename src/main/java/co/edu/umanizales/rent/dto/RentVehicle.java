package co.edu.umanizales.rent.dto;

public class RentVehicle {
    private String plateNumber;

    public RentVehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
