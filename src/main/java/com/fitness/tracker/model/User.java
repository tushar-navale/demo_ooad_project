package com.fitness.tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 2, message = "Password must be at least 2 characters long")
    private String password;

    private Integer age;
    private String gender;
    private Double weight;
    private Double height;
    private String fitnessLevel;

    @OneToMany(mappedBy = "user")
    private List<BlogPost> blogPosts;
}