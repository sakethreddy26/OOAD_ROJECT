package com.yourcompany.vehiclerentalsystem.service;

import com.yourcompany.vehiclerentalsystem.model.User;

public interface UserService {
    void signup(User user);
    User login(String username, String password);
}
