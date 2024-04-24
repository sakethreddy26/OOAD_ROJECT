package com.yourcompany.vehiclerentalsystem.service;

import com.yourcompany.vehiclerentalsystem.model.DriverLogin;
import com.yourcompany.vehiclerentalsystem.repository.DriverLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DriverLoginServiceImpl implements DriverLoginService {

    @Autowired
    private DriverLoginRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void signup(DriverLogin user) {
        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public DriverLogin login(String username, String password) {
        DriverLogin user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Passwords match, return the user
            return user;
        } else {
            // Either user not found or passwords don't match
            return null;
        }
    }
}
