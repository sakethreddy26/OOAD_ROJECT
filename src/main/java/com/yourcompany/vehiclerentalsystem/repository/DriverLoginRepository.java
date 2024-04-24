package com.yourcompany.vehiclerentalsystem.repository;

import com.yourcompany.vehiclerentalsystem.model.DriverLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverLoginRepository extends MongoRepository<DriverLogin, String> {
    DriverLogin findByUsername(String username);
}
