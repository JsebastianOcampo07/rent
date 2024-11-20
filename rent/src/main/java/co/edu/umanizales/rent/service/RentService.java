package co.edu.umanizales.rent.service;

import co.edu.umanizales.rent.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public RentService() {
        // Datos de ejemplo
        vehicles.add(new Vehicle("ABC123", "Car", true));
        vehicles.add(new Vehicle("XYZ987", "Moto", true));
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public Optional<Vehicle> getVehicleByPlate(String plateNumber) {
        return vehicles.stream().filter(v -> v.getPlateNumber().equals(plateNumber)).findFirst();
    }

    public boolean rentVehicle(String plateNumber) {
        Optional<Vehicle> vehicle = getVehicleByPlate(plateNumber);
        if (vehicle.isPresent() && vehicle.get().isAvailable()) {
            vehicle.get().setAvailable(false);
            return true;
        }
        return false;
    }
}
