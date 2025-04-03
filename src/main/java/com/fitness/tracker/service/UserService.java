package com.fitness.tracker.service;

import com.fitness.tracker.model.User;
import com.fitness.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User userDetails) {
        User user = findById(id);
        
        user.setAge(userDetails.getAge());
        user.setGender(userDetails.getGender());
        user.setWeight(userDetails.getWeight());
        user.setHeight(userDetails.getHeight());
        user.setFitnessLevel(userDetails.getFitnessLevel());
        
        return userRepository.save(user);
    }
}