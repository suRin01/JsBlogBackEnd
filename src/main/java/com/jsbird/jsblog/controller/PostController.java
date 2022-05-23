package com.jsbird.jsblog.controller;

import com.jsbird.jsblog.exceptions.noRowSelected;
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
    @GetMapping("/{postIdx}")
    public Response<?> findSinglePost(@PathVariable Integer postIdx){
        try {
            return ApiUtils.success(postService.findSinglePost(postIdx));
        } catch (noRowSelected e) {
            log.error(e.getMessage());
            return ApiUtils.error("No Post Found", 404);

        } catch (Exception e){
            log.error(e.getMessage());
        }
        return ApiUtils.error("Internal Error", 500);
    }

    @GetMapping("")
    public Response<?> findCategorizedPosts(@RequestParam Integer category){
        // TODO: Get User idx by session
        Integer USERIDX = 2;
        return ApiUtils.success(postService.findSameCategorizedPostsOnUser(USERIDX, category));
    }
}
