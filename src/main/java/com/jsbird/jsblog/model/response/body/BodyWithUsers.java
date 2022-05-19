package com.jsbird.jsblog.model.response.body;

import com.jsbird.jsblog.model.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BodyWithUsers {
    private final Member[] member;
}
