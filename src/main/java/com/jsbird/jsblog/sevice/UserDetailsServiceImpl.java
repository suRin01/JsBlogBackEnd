package com.jsbird.jsblog.sevice;

import com.jsbird.jsblog.model.Entity.Member;
import com.jsbird.jsblog.model.SecurityUser;
import com.jsbird.jsblog.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Member> memberList = memberRepository.findByUserId(username);
        if(memberList.size() == 0) throw new UsernameNotFoundException("User Not Found");
        log.info("loadUserByUsername member.username = {}", username);


        return new SecurityUser(memberList.get(0));
    }
}
