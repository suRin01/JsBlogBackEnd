package com.jsbird.jsblog.model;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("관리자"), ROLE_DEVELOPER("개발자"), ROLE_MEMBER("일반사용자");

    private String description;

    Role(String description) {
        this.description = description;
    }
}
