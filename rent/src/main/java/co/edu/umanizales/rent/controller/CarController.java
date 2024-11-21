package co.edu.umanizales.rent.controller;

import co.edu.umanizales.rent.dto.ResponseFilter;
import co.edu.umanizales.rent.service.RentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private final RentService rentService;

    public CarController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/filter/{color}")
    public List<ResponseFilter> filterVehiclesByColor(@PathVariable String color) {
        return rentService.filterByColor(color);
    }
}
