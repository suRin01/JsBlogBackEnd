package com.jsbird.jsblog.model;

import com.jsbird.jsblog.model.Entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Slf4j
@Getter
@Setter
public class SecurityUser extends User {
    private Member member;

    public SecurityUser(Member member){
        super(member.getUserId(), member.getPassword(), AuthorityUtils.createAuthorityList(Role.ROLE_MEMBER.getDescription()));
        log.info("SecurityUser member.username = {}", member.getUserId());
        log.info("SecurityUser member.password = {}", member.getPassword());

        this.member = member;
    }
}
