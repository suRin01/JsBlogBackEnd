package com.jsbird.jsblog.repositories;

import com.jsbird.jsblog.model.Entity.PostWithUserAndLike;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostWithUserAndLikeRepository extends JpaRepository<PostWithUserAndLike, Integer> {
    List<PostWithUserAndLike> findByOrderByUpdatedAtAsc(Pageable pageable);

    List<PostWithUserAndLike> findByIdx(Integer idx);

    List<PostWithUserAndLike> findByCategoryIdx(Integer categoryIdx);

    List<PostWithUserAndLike> findByMemberIdxAndCategoryIdx(Integer memberIdx, Integer categoryIdx);

}