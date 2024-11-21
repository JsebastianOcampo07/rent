package co.edu.umanizales.rent.service;

import co.edu.umanizales.rent.model.ResponseFilter;
import co.edu.umanizales.rent.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RentService {
    private List<Vehicle> vehicles;

    public RentService() {
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("ABC123", "Car", "Red", true));
        vehicles.add(new Vehicle("XYZ987", "Motorcycle", "Blue", true));
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

    public List<ResponseFilter> filterVehiclesByColor(String color) {
        Map<String, Integer> colorCount = new HashMap<>();
        colorCount.put("Car", 0);
        colorCount.put("Motorcycle", 0);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                int currentCount = colorCount.get(vehicle.getType());
                colorCount.put(vehicle.getType(), currentCount + 1);
            }
        }

        List<ResponseFilter> filters = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            filters.add(new ResponseFilter(entry.getKey(), entry.getValue()));
        }

        return filters;
    }

}

