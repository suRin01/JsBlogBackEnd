package com.jsbird.jsblog.model.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "post_with_user_and_like")
public class PostWithUserAndLike {
    @Id
    @Column(name = "idx")
    private Integer idx;

    @Lob
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "contents")
    private String contents;

    @Lob
    @Column(name = "summary")
    private String summary;

    @Column(name = "is_private")
    private Integer isPrivate;

    @Column(name = "thumbnail", length = 45)
    private String thumbnail;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "category_idx")
    private Integer categoryIdx;

    @Column(name = "member_idx", nullable = false)
    private Integer memberIdx;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "avatar", length = 15)
    private String avatar;

    @Column(name = "introduction", length = 300)
    private String introduction;

    @Column(name = "likes")
    private Long likes;

    @Column(name = "comment")
    private Long comment;


    protected PostWithUserAndLike() {
    }
}