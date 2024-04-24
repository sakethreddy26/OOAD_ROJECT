package com.yourcompany.vehiclerentalsystem.controller;

import java.util.Optional;
import com.yourcompany.vehiclerentalsystem.model.Car;
import com.yourcompany.vehiclerentalsystem.model.Driver;
import com.yourcompany.vehiclerentalsystem.repository.CarRepository;
import com.yourcompany.vehiclerentalsystem.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/booking")
    public String showBookingPage(@RequestParam("carId") String carId, Model model) {
        // Retrieve the car by its ID
        Optional<Car> optionalCar = carRepository.findById(carId);

        // Check if the car is present
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            model.addAttribute("car", car); // Add car to the model

            // Retrieve the driver associated with the car
            Driver driver = driverRepository.findByCarId(carId);
            if (driver != null) {
                model.addAttribute("driver", driver); // Add driver to the model
            } else {
                // Add a message indicating no driver found for the car
                System.out.println("No driver");
                model.addAttribute("driverNotFound", true);
            }
        } else {
            // Add a message indicating no car found with the provided ID
            model.addAttribute("carNotFound", true);
        }

        return "booking"; // Return the booking view
    }


}
