package com.fitness.tracker.service;

import com.fitness.tracker.model.BlogPost;
import com.fitness.tracker.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllBlogs() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogById(Long id) {
        return blogPostRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
    }

    public BlogPost createBlog(BlogPost blog) {
        if (blog.getTitle() == null || blog.getTitle().trim().isEmpty()) {
            throw new RuntimeException("Blog title cannot be empty");
        }
        if (blog.getContent() == null || blog.getContent().trim().isEmpty()) {
            throw new RuntimeException("Blog content cannot be empty");
        }
        return blogPostRepository.save(blog);
    }

    public BlogPost updateBlog(Long id, BlogPost blogDetails) {
        BlogPost blog = getBlogById(id);
        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());
        return blogPostRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        BlogPost blog = getBlogById(id);
        blogPostRepository.delete(blog);
    }

    public BlogPost likeBlog(Long id) {
        BlogPost blog = getBlogById(id);
        blog.setLikes(blog.getLikes() + 1);
        return blogPostRepository.save(blog);
    }
}