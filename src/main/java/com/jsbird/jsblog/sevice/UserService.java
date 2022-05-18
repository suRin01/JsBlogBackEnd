package com.jsbird.jsblog.sevice;

import com.jsbird.jsblog.exceptions.noRowSelected;
import com.jsbird.jsblog.model.Entity.User;
import com.jsbird.jsblog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public User findSingleUserById(String userId) throws noRowSelected {
        List<User> userList = userRepository.findByUserId(userId);
        if(userList.size() > 0){
            return userList.get(0);
        }
        else{
            throw new noRowSelected("There is no existing user on id "+userId);
        }
    }

    public User findSingleUserByIdx(Integer userIdx) throws noRowSelected{
        List<User> userList = userRepository.findByIdxIs(userIdx);
        if(userList.size() > 0){
            return userList.get(0);
        }
        else{
            throw new noRowSelected("There is no existing user on idx"+userIdx);
        }
    }
}
