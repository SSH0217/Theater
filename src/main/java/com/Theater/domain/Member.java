package com.Theater.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String socialSecurityNumber;
    private boolean isAdmin;
    private String sex;
    private Integer age;

}
