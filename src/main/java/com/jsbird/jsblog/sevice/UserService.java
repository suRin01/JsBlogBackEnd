package com.jsbird.jsblog.sevice;

import com.jsbird.jsblog.exceptions.noRowSelected;
import com.jsbird.jsblog.model.Entity.Member;
import com.jsbird.jsblog.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    final private MemberRepository memberRepository;

    public Boolean createUser(Member member) throws RuntimeException{
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        try {
            memberRepository.save(member);
            return Boolean.TRUE;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public Member findSingleUserById(String userId) throws noRowSelected {
        List<Member> userList = memberRepository.findByUserId(userId);
        if(userList.size() > 0){

            return userList.get(0);
        }
        else{
            throw new noRowSelected("There is no existing user on id="+userId);
        }
    }

    public Member findSingleUserByIdx(Integer userIdx) throws noRowSelected{
        List<Member> userList = memberRepository.findByIdxIs(userIdx);
        if(userList.size() > 0){
            return userList.get(0);
        }
        else{
            throw new noRowSelected("There is no existing user on idx="+userIdx);
        }
    }

    public Boolean updateSingleUser(Integer userIdx, Member updateMember) throws noRowSelected {
        Member member = findSingleUserByIdx(userIdx);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        member.setPassword(passwordEncoder.encode(updateMember.getPassword()));
        member.setAvatar(updateMember.getAvatar());
        member.setIntroduction(updateMember.getIntroduction());

        memberRepository.save(member);

        return Boolean.TRUE;
    }

    public Boolean deleteSingleUser(Integer userIdx) throws noRowSelected{
        Member member = findSingleUserByIdx(userIdx);

        memberRepository.delete(member);

        return Boolean.TRUE;
    }

}
