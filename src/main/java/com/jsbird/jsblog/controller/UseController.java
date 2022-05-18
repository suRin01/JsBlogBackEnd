package com.jsbird.jsblog.controller;

import com.jsbird.jsblog.exceptions.noRowSelected;
import com.jsbird.jsblog.model.Entity.User;
import com.jsbird.jsblog.sevice.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UseController {
    private final UserService userService;

    @GetMapping("/{userIdx}")
    public User getOneUser(@PathVariable Integer userIdx){
        try {
            return userService.findSingleUserByIdx(userIdx);
        } catch (noRowSelected e) {
            log.error(e.getMessage());

        }
        return null;
    }

    @GetMapping("")
    public User getOneUserOnId(@RequestParam String id){
        try {
            return userService.findSingleUserById(id);
        } catch (noRowSelected e) {
            log.error(e.getMessage());

        }
        return null;

    }
}
