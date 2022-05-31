package com.jsbird.jsblog.controller;

import com.jsbird.jsblog.exceptions.noRowSelected;
import com.jsbird.jsblog.model.Entity.Member;
import com.jsbird.jsblog.model.response.Response;
import com.jsbird.jsblog.model.response.body.BodyWithUser;
import com.jsbird.jsblog.sevice.UserService;
import com.jsbird.jsblog.utiliy.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UserController {
    private final UserService userService;

    //Create Single User
    @PostMapping("")
    public Response<?> createUser(Member member){
        log.info(member.toString());
        try {
            if (userService.createUser(member)){
                return ApiUtils.success();
            }
            return ApiUtils.error("User Creation Failed.", 500);

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    //Get Single User By User Idx
    @GetMapping("/{userIdx}")
    public Response<?> getOneUser(@PathVariable Integer userIdx){
        try {
//            return ApiUtils.success(userService.findSingleUserByIdx(userIdx));
            return ApiUtils.success(new BodyWithUser(userService.findSingleUserByIdx(userIdx)));
        } catch (noRowSelected e) {
            log.error(e.getMessage());
            return ApiUtils.error("No User Found", 404);

        } catch (Exception e){
            log.error(e.getMessage());
        }
        return ApiUtils.error("Internal Error", 500);
    }

    //Get Single User By User Id
    @GetMapping("")
    public Response<?> getOneUserOnId(@RequestParam String id){
        try {
            return ApiUtils.success(new BodyWithUser(userService.findSingleUserById(id)));
        } catch (noRowSelected e) {
            log.error(e.getMessage());
            return ApiUtils.error("No User Found", 404);

        } catch (Exception e){
            log.error(e.getMessage());
        }
        return ApiUtils.error("Internal Error", 500);

    }

    @GetMapping("/me")
    public Response<?> getMyUserInformation(HttpServletRequest request){
        return ApiUtils.success(userService.getMyUserWithAuthorities());

    }

    @PatchMapping("/{userIdx}")
    public Response<?> patchOneUser(@PathVariable Integer userIdx, @RequestBody Member member){
        try{
            System.out.println(member.toString());
            userService.updateSingleUser(userIdx, member);

            return ApiUtils.success();
        }catch (noRowSelected e){
            log.error(e.getMessage());
            return ApiUtils.error("No User Found", 404);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return ApiUtils.error("Internal Error", 500);
    }

    @DeleteMapping("/{userIdx}")
    public Response<?> deleteOneUser(@PathVariable Integer userIdx){
        try {
            userService.deleteSingleUser(userIdx);
            ApiUtils.success();
        }catch (noRowSelected e){
            log.error(e.getMessage());
            return ApiUtils.error("No User Found", 404);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return ApiUtils.error("Internal Error", 500);

    }

    //TODO /api/users/me
    // - 요청한 클라이언트의 session값을 기반으로 자기 자신의 데이터 조회
}
