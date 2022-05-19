package com.jsbird.jsblog.repositories;

import com.jsbird.jsblog.model.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}