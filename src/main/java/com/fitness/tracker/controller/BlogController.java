package com.fitness.tracker.controller;

import com.fitness.tracker.model.BlogPost;
import com.fitness.tracker.model.Comment;
import com.fitness.tracker.repository.BlogPostRepository;
import com.fitness.tracker.repository.CommentRepository;
import com.fitness.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fitness.tracker.model.User;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogPostRepository blogPostRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<BlogPost> getAllBlogs() {
        return blogPostRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/user/{userId}")
    public List<BlogPost> getUserBlogs(@PathVariable Long userId) {
        return blogPostRepository.findByUserId(userId);
    }

    @PostMapping("/{userId}")
    public BlogPost createBlog(@PathVariable Long userId, @RequestBody BlogPost blogPost) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            blogPost.setUser(user);
            return blogPostRepository.save(blogPost);
        }
        return null;
    }

    @PostMapping("/{postId}/like")
    public BlogPost likeBlog(@PathVariable Long postId) {
        BlogPost post = blogPostRepository.findById(postId).orElse(null);
        if (post != null) {
            post.setLikes(post.getLikes() + 1);
            return blogPostRepository.save(post);
        }
        return null;
    }

    @PostMapping("/{postId}/comment/{userId}")
    public Comment addComment(@PathVariable Long postId, @PathVariable Long userId, @RequestBody Comment comment) {
        BlogPost post = blogPostRepository.findById(postId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (post != null && user != null) {
            comment.setPost(post);
            comment.setUser(user);
            return commentRepository.save(comment);
        }
        return null;
    }
}