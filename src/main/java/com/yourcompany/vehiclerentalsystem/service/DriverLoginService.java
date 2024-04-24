package com.yourcompany.vehiclerentalsystem.service;

import com.yourcompany.vehiclerentalsystem.model.DriverLogin;


public interface DriverLoginService {
    void signup(DriverLogin user);
    DriverLogin login(String username, String password);
}
