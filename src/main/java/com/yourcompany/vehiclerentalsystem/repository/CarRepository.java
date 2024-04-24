package com.yourcompany.vehiclerentalsystem.repository;

import com.yourcompany.vehiclerentalsystem.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {


}
