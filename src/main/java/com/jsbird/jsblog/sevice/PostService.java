package com.jsbird.jsblog.sevice;

import com.jsbird.jsblog.model.Entity.Post;
import com.jsbird.jsblog.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Boolean createSinglePost(Post post){
        postRepository.save(post);

        return Boolean.TRUE;
    }

    public Post findSinglePost(Integer postIdx){
        Post post =  postRepository.findById(postIdx);
        if(post.getId() != null){
            return post;
        }else{
            log.error("entity not found");
        }
        return null;
    }

}
