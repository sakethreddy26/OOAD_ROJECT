package com.yourcompany.vehiclerentalsystem.repository;

import com.yourcompany.vehiclerentalsystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
