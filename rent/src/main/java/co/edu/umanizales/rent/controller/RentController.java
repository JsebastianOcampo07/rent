package co.edu.umanizales.rent.controller;

import co.edu.umanizales.rent.dto.RentVehicle;
import co.edu.umanizales.rent.model.ResponseFilter;
import co.edu.umanizales.rent.model.Vehicle;
import co.edu.umanizales.rent.service.RentService;
import co.edu.umanizales.rent.service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return rentService.getAllVehicles();
    }

    @PostMapping("/rent/{userName}/{password}")
    public String rentVehicle(@RequestBody RentVehicle rentVehicle, @PathVariable String userName, @PathVariable String password) {
        boolean isValid = userEmployeeService.loginValidate(userName, password);
        if (isValid) {
            boolean success = rentService.rentVehicle(rentVehicle.getPlateNumber());
            return success ? "Vehículo alquilado exitosamente." : "El vehículo no está disponible.";
        }
        return "No tienes permisos para alquilar un vehículo.";
    }

    @GetMapping("/filter-color/{color}")
    public List<ResponseFilter> filterVehiclesByColor(@PathVariable String color) {
        return rentService.filterVehiclesByColor(color);
    }
}
