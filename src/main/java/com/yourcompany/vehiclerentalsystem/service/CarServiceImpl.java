package com.yourcompany.vehiclerentalsystem.service;

import com.yourcompany.vehiclerentalsystem.model.Car;
import com.yourcompany.vehiclerentalsystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}