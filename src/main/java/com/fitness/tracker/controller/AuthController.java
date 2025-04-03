package com.fitness.tracker.controller;

import com.fitness.tracker.model.User;
import com.fitness.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        try {
            User user = userRepository.findByEmail(loginRequest.getEmail());
            if (user == null) {
                return ResponseEntity.badRequest()
                    .body("User not found with email: " + loginRequest.getEmail());
            }
            
            if (!user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.badRequest()
                    .body("Invalid password");
            }
            
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("Error during login: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            // Check if user already exists
            if (userRepository.findByEmail(user.getEmail()) != null) {
                return ResponseEntity.badRequest()
                    .body("User already exists with email: " + user.getEmail());
            }
            
            // Save new user
            User savedUser = userRepository.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("Error during registration: " + e.getMessage());
        }
    }
}