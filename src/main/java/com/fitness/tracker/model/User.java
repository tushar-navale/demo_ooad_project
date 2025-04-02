package com.fitness.tracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private Double weight;
    private Double height;
    private String fitnessLevel;

    @OneToMany(mappedBy = "user")
    private List<BlogPost> blogPosts;
}