package co.edu.umanizales.rent.dto;

public class ResponseFilter {
    private String vehicleType;
    private int count;

    public ResponseFilter(String vehicleType, int count) {
        this.vehicleType = vehicleType;
        this.count = count;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
