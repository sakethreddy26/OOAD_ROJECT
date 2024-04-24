package com.yourcompany.vehiclerentalsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("com.yourcompany.vehiclerentalsystem")
public class VehicleRentalSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(VehicleRentalSystemApplication.class, args);
    }
}
