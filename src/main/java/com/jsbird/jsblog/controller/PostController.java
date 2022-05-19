package com.jsbird.jsblog.controller;

import com.jsbird.jsblog.model.response.Response;
import com.jsbird.jsblog.sevice.PostService;
import com.jsbird.jsblog.utiliy.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
//
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/posts")
public class PostController {
    private final PostService postService;
//
////    @PostMapping("")
////    public Response<?> createSinglePost(Post post){
//        return ApiUtils.success(postService.findSinglePost(post));
//    }

    @GetMapping("/{postIdx}")
    public Response<?> findSinglePost(@PathVariable Integer postIdx){
        return ApiUtils.success(postService.findSinglePost(postIdx));
    }
}
