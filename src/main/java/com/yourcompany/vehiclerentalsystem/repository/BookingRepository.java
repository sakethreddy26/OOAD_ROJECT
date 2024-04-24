package com.yourcompany.vehiclerentalsystem.repository;

import com.yourcompany.vehiclerentalsystem.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
