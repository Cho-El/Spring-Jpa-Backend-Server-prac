package com.sparta.assignment.repository;

import com.sparta.assignment.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findById(Long id);
    List<Post> findAllByOrderByModifiedAtDesc();
}

