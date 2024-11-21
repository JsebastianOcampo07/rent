package co.edu.umanizales.rent.controller;

import co.edu.umanizales.rent.dto.RentVehicle;
import co.edu.umanizales.rent.dto.ResponseFilter;
import co.edu.umanizales.rent.model.Vehicle;
import co.edu.umanizales.rent.model.VehicleBase;
import co.edu.umanizales.rent.service.RentService;
import co.edu.umanizales.rent.service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rent")
public class RentController {
    private final RentService rentService;
    private final UserEmployeeService userEmployeeService;

    @Autowired
    public RentController(RentService rentService, UserEmployeeService userEmployeeService) {
        this.rentService = rentService;
        this.userEmployeeService = userEmployeeService;
    }

    // Obtener todos los vehículos
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return rentService.getAllVehicles();
    }

    // Rentar un vehículo
    @PostMapping("/rent/{userName}/{password}")
    public String rentVehicle(@RequestBody RentVehicle dataRent, @PathVariable String userName, @PathVariable String password) {
        try {
            boolean isValidUser = userEmployeeService.loginValidate(userName, password);
            if (isValidUser) {
                boolean success = rentService.rentVehicle(dataRent.getPlateNumber());
                return success ? "Vehículo alquilado exitosamente." : "El vehículo no está disponible o no existe.";
            } else {
                return "No tienes permiso para rentar un vehículo.";
            }
        } catch (Exception e) {
            return "Error al rentar el vehículo: " + e.getMessage();
        }
    }

    // Agregar un vehículo
    @PostMapping("/add/{userName}/{password}")
    public String addVehicle(@RequestBody VehicleBase car, @PathVariable String userName, @PathVariable String password) {
        try {
            boolean isValidAdmin = userEmployeeService.loginValidateAdmin(userName, password);
            if (isValidAdmin) {
                rentService.addVehicle(car);
                return "Vehículo agregado correctamente.";
            } else {
                return "No tienes permiso para agregar un vehículo.";
            }
        } catch (Exception e) {
            return "Error al agregar el vehículo: " + e.getMessage();
        }
    }

    // Filtrar vehículos por color
    @GetMapping("/filter-color/{color}")
    public Map<String, Integer> filterByColor(@PathVariable String color) {
        try {
            return rentService.filterVehiclesByColor(color);
        } catch (Exception e) {
            throw new RuntimeException("Error al filtrar vehículos por color: " + e.getMessage());
        }
    }
}
