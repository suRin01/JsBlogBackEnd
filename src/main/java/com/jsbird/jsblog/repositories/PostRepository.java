package com.jsbird.jsblog.repositories;

import com.jsbird.jsblog.model.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}