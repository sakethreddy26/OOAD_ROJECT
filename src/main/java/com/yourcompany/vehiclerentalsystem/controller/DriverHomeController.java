package com.yourcompany.vehiclerentalsystem.controller;

import com.yourcompany.vehiclerentalsystem.model.DriverHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yourcompany.vehiclerentalsystem.repository.DriverHomeRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class DriverHomeController {

    @Autowired
    private DriverHomeRepository driverHomeRepository;

    // Logger instance
    private static final Logger LOGGER = Logger.getLogger(DriverHomeController.class.getName());

    @GetMapping("/driverhome")
    public String driverHome(@RequestParam("username") String username, Model model) {
        LOGGER.info("Fetching driver home for username: " + username);
        DriverHome driverHome = driverHomeRepository.findByUsername(username);
        if (driverHome != null) {
            LOGGER.info("Driver home found for username: " + username);
            LOGGER.info("Driver home details:");
            LOGGER.info("Driver ID: " + driverHome.getCarMake());
            LOGGER.info("Driver Name: " + driverHome.getDriverName());
            // Log other attributes as needed
        } else {
            LOGGER.warning("No driver home found for username: " + username);
        }
        model.addAttribute("driverHome", driverHome);
        return "driverhome";
    }

    @PostMapping("/driverhome1")
    public String endRide(@RequestParam("username") String username,
                          @RequestParam("final-price") double finalPrice,
                          Model model) {
        LOGGER.info("Ending ride for username: " + username);
        DriverHome driverHome = driverHomeRepository.findByUsername(username);
        if (driverHome != null) {
            LOGGER.info("Updating ride fare for username: " + username);
            driverHome.setPrice(finalPrice);
            // Save the updated record back to the database
            driverHomeRepository.save(driverHome);
            LOGGER.info("Ride fare updated successfully");
        } else {
            LOGGER.warning("No driver home found for username: " + username);
        }
        return "redirect:/driverhome1?username=" + username;
    }

    @GetMapping("/driverhome1")
    public String driverHome1(@RequestParam("username") String username, Model model) {
        LOGGER.info("Fetching driver home for username: " + username);
        DriverHome driverHome = driverHomeRepository.findByUsername(username);
        if (driverHome != null) {
            LOGGER.info("Driver home found for username: " + username);
            LOGGER.info("Driver home details:");
            LOGGER.info("Driver ID: " + driverHome.getCarMake());
            LOGGER.info("Driver Name: " + driverHome.getDriverName());
            // Log other attributes as needed
        } else {
            LOGGER.warning("No driver home found for username: " + username);
        }
        model.addAttribute("driverHome", driverHome);
        return "ride";
    }

    @GetMapping("/managebooking")
    public String manageBooking(@RequestParam("username") String username, Model model) {
        LOGGER.info("Fetching driver home for username: " + username);
        DriverHome driverHome = driverHomeRepository.findByUsername(username);
        if (driverHome != null) {
            LOGGER.info("Driver home found for username: " + username);
            LOGGER.info("Driver home details:");
            LOGGER.info("Driver ID: " + driverHome.getCarMake());
            LOGGER.info("Driver Name: " + driverHome.getDriverName());
            // Log other attributes as needed
        } else {
            LOGGER.warning("No driver home found for username: " + username);
        }
        model.addAttribute("driverHome", driverHome);
        return "managebooking";
    }
}
