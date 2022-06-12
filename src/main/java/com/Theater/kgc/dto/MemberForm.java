package com.Theater.kgc.dto;

import com.Theater.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberForm {
    private String name;
    private String id;
    private String password;
    private String phoneNumber;
    private String sex;
    private Integer age;

    public MemberForm(Member member){
        this.name = member.getName();
        this.id = member.getLoginId();
        this.password = member.getPassword();
        this.phoneNumber = member.getSocialSecurityNumber();
        this.sex = member.getSex();
        this.age = member.getAge();
    }
}
