package com.fitness.tracker.repository;

import com.fitness.tracker.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findAllByOrderByCreatedAtDesc();
    List<BlogPost> findByUserId(Long userId);
}