package co.edu.umanizales.rent.dto;

public class RentVehicle {
    private String documentNumber;
    private String licensePlate;

    public RentVehicle(String documentNumber, String licensePlate) {
        this.documentNumber = documentNumber;
        this.licensePlate = licensePlate;
    }
    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
{
}
