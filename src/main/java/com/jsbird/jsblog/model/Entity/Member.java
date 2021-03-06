package com.jsbird.jsblog.model.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx", nullable = false)
    private Integer idx;

    @Column(name = "id", nullable = false, length = 25)
    private String userId;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "avatar", length = 15)
    private String avatar;

    @Column(name = "introduction", length = 300)
    private String introduction;

    @Column(name = "authority", nullable = false)
    private Integer authority;

}