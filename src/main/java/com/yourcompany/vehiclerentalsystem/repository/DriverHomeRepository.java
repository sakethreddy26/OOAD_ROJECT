package com.yourcompany.vehiclerentalsystem.repository;

import com.yourcompany.vehiclerentalsystem.model.DriverHome;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverHomeRepository extends MongoRepository<DriverHome, String> {
    DriverHome findByUsername(String username);
}