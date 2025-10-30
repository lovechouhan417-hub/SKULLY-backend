package com.skully.skully.service;

import com.skully.skully.dto.RegisterRequest;
import com.skully.skully.model.User;
import com.skully.skully.repository.UserRepository;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    // private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterRequest req) {
        // optionally check if email exists
        var existing = userRepository.findAll().stream()
            .filter(u -> req.getEmail().equalsIgnoreCase(u.getEmail()))
            .findAny();
        if (existing.isPresent()) return null; // or throw

        User u = new User();
       u.setFirstName(req.getFirstName());
        u.setLastName(req.getLastName());
        u.setEmail(req.getEmail());
        u.setMobileNumber(req.getMobileNumber());
        u.setVillageName(req.getVillageName());
        u.setDistrictName(req.getDistrictName());
        u.setPassword(req.getPassword()); // you need to add field passwordHash to User entity
        return userRepository.save(u);
    }

 
}