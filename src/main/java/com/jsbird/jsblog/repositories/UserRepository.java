package com.jsbird.jsblog.repositories;

import com.jsbird.jsblog.model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUserId(@NonNull String userId);
    List<User> findByIdxIs(@NonNull Integer idx);
}