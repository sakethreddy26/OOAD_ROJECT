package com.yourcompany.vehiclerentalsystem.service;

import com.yourcompany.vehiclerentalsystem.model.DriverHome;
import com.yourcompany.vehiclerentalsystem.repository.DriverHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverHomeService {

    private final DriverHomeRepository driverHomeRepository;

    @Autowired
    public DriverHomeService(DriverHomeRepository driverHomeRepository) {
        this.driverHomeRepository = driverHomeRepository;
    }

    public DriverHome saveBooking(DriverHome booking) {
        return driverHomeRepository.save(booking);
    }
}
