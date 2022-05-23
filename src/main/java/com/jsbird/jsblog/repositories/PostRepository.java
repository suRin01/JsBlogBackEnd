package com.jsbird.jsblog.repositories;

import com.jsbird.jsblog.model.Entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByOrderByCreatedAtAsc(Pageable pageable);
    List<Post> findByIdxIs(Integer integer);
}