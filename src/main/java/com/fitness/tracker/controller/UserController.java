package com.fitness.tracker.controller;

import com.fitness.tracker.model.User;
//import com.fitness.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fitness.tracker.service.UserService;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
// @RequestMapping("/api/users")
// @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
// public class UserController {
    
//     @Autowired
//     private UserRepository userRepository;
    
//     @GetMapping("/{id}")
//     public ResponseEntity<User> getUser(@PathVariable Long id) {
//         return userRepository.findById(id)
//             .map(ResponseEntity::ok)
//             .orElse(ResponseEntity.notFound().build());
//     }
    
//     @PutMapping("/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//         return userRepository.findById(id)
//             .map(user -> {
//                 user.setName(userDetails.getName());
//                 user.setAge(userDetails.getAge());
//                 user.setGender(userDetails.getGender());
//                 user.setWeight(userDetails.getWeight());
//                 user.setHeight(userDetails.getHeight());
//                 user.setFitnessLevel(userDetails.getFitnessLevel());
//                 return ResponseEntity.ok(userRepository.save(user));
//             })
//             .orElse(ResponseEntity.notFound().build());
//     }
// }

// @RestController
// @RequestMapping("/api/users")
// @CrossOrigin(origins = "http://localhost:3000", 
//              methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE},
//              allowedHeaders = "*")
// public class UserController {
    
//     @Autowired
//     private UserRepository userRepository;
    
//     @GetMapping("/{id}")
//     public ResponseEntity<User> getUser(@PathVariable Long id) {
//         return userRepository.findById(id)
//             .map(ResponseEntity::ok)
//             .orElse(ResponseEntity.notFound().build());
//     }
    
//     @PutMapping("/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//         System.out.println("Received PUT request for user ID: " + id);
//         return userRepository.findById(id)
//             .map(user -> {
//                 user.setName(userDetails.getName());
//                 user.setAge(userDetails.getAge());
//                 user.setGender(userDetails.getGender());
//                 user.setWeight(userDetails.getWeight());
//                 user.setHeight(userDetails.getHeight());
//                 user.setFitnessLevel(userDetails.getFitnessLevel());
//                 User updatedUser = userRepository.save(user);
//                 System.out.println("Updated user: " + updatedUser);
//                 return ResponseEntity.ok(updatedUser);
//             })
//             .orElse(ResponseEntity.notFound().build());
//     }
// }

// package com.fitness.tracker.controller;

// import com.fitness.tracker.model.User;
// import com.fitness.tracker.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }
}