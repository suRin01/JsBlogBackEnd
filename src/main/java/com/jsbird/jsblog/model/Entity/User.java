package com.jsbird.jsblog.model.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx", nullable = false)
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
}