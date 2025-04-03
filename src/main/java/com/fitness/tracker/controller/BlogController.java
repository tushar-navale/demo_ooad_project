package com.fitness.tracker.controller;

import com.fitness.tracker.model.BlogPost;
import com.fitness.tracker.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class BlogController {
    
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlog(@RequestBody BlogPost blog) {
        return ResponseEntity.ok(blogService.createBlog(blog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlog(@PathVariable Long id, @RequestBody BlogPost blogDetails) {
        return ResponseEntity.ok(blogService.updateBlog(id, blogDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<BlogPost> likeBlog(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.likeBlog(id));
    }
}