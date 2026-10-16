package com.example.practical.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practical.test.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}