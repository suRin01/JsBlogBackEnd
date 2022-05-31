package com.jsbird.jsblog.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name = "authority_name", nullable = false, length = 20)
    private String authorityName;

}