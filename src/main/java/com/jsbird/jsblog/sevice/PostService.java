package com.jsbird.jsblog.sevice;

import com.jsbird.jsblog.exceptions.noRowSelected;
import com.jsbird.jsblog.model.Entity.Post;
import com.jsbird.jsblog.model.Entity.PostWithUserAndLike;
import com.jsbird.jsblog.repositories.PostRepository;
import com.jsbird.jsblog.repositories.PostWithUserAndLikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostWithUserAndLikeRepository postWithUserAndLikeRepository;

    public Boolean createSinglePost(Post post){
        postRepository.save(post);

        return Boolean.TRUE;
    }

    public PostWithUserAndLike findSinglePost(Integer postIdx) throws noRowSelected {
        List<PostWithUserAndLike> posts =  postWithUserAndLikeRepository.findByIdx(postIdx);
        if(posts.size() == 0) throw new noRowSelected("There is no existing post on idx="+postIdx);
        return posts.get(0);
    }

    public List<PostWithUserAndLike> findSameCategorizedPostsOnUser(Integer userIdx, Integer categoryIdx){
        return postWithUserAndLikeRepository.findByMemberIdxAndCategoryIdx(userIdx, categoryIdx);

    }
}
