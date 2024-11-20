package co.edu.umanizales.rent.controller;

import co.edu.umanizales.rent.model.Vehicle;
import co.edu.umanizales.rent.service.RentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return rentService.getAllVehicles();
    }

    @PostMapping("/rent/{plateNumber}")
    public String rentVehicle(@PathVariable String plateNumber) {
        boolean success = rentService.rentVehicle(plateNumber);
        if (success) {
            return "Vehículo alquilado exitosamente.";
        } else {
            return "El vehículo no está disponible o no existe.";
        }
    }
}
