package co.edu.umanizales.rent.service;

import co.edu.umanizales.rent.dto.ResponseFilter;
import co.edu.umanizales.rent.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public RentService() {
        vehicles.add(new Vehicle("ABC123", "Car", true, "Red"));
        vehicles.add(new Vehicle("XYZ987", "Motorcycle", true, "Blue"));
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

    public List<ResponseFilter> filterByColor(String color) {
        int carCount = 0, motorcycleCount = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                if ("Car".equalsIgnoreCase(vehicle.getType())) {
                    carCount++;
                } else if ("Motorcycle".equalsIgnoreCase(vehicle.getType())) {
                    motorcycleCount++;
                }
            }
        }
        List<ResponseFilter> filters = new ArrayList<>();
        filters.add(new ResponseFilter("Car", carCount));
        filters.add(new ResponseFilter("Motorcycle", motorcycleCount));
        return filters;
    }
}

