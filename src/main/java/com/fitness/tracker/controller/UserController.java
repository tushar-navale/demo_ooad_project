package com.fitness.tracker.controller;

import com.fitness.tracker.model.User;
import com.fitness.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {
//     @Autowired
//     private UserRepository userRepository;

//     @GetMapping("/{id}")
//     public User getUser(@PathVariable Long id) {
//         return userRepository.findById(id).orElse(null);
//     }

//     @PutMapping("/{id}")
//     public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//         User user = userRepository.findById(id).orElse(null);
//         if (user != null) {
//             user.setName(userDetails.getName());
//             user.setAge(userDetails.getAge());
//             user.setGender(userDetails.getGender());
//             user.setWeight(userDetails.getWeight());
//             user.setHeight(userDetails.getHeight());
//             user.setFitnessLevel(userDetails.getFitnessLevel());
//             return userRepository.save(user);
//         }
//         return null;
//     }
// }

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}