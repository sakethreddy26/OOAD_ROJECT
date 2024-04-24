package com.yourcompany.vehiclerentalsystem.controller;

import com.yourcompany.vehiclerentalsystem.model.Car;
import com.yourcompany.vehiclerentalsystem.model.Driver;
import com.yourcompany.vehiclerentalsystem.service.CarService;
import com.yourcompany.vehiclerentalsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CarService carService;
    private final DriverService driverService;

    @Autowired
    public HomeController(CarService carService, DriverService driverService) {
        this.carService = carService;
        this.driverService = driverService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Car> cars = carService.getAllCars();
        List<Driver> drivers = driverService.getAllDrivers();

        model.addAttribute("cars", cars);
        model.addAttribute("drivers", drivers);

        return "home";
    }
}