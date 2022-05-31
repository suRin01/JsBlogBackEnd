package com.jsbird.jsblog.repositories;

import com.jsbird.jsblog.model.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findByUserId(@NonNull String userId);
    List<Member> findByIdxIs(@NonNull Integer idx);


}