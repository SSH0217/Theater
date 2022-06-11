package com.Theater.rhg.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.Theater.domain.Member;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String socialSecurityNumber;
    private boolean isAdmin;
    private String sex;
    private Integer age;

    public MemberDto(Member member){
        this.id=member.getId();
        this.loginId= member.getLoginId();
        this.password=member.getPassword();
        this.name= member.getName();
        this.socialSecurityNumber= member.getSocialSecurityNumber();
        this.isAdmin= member.isAdmin();
        this.sex= member.getSex();
        this.age= member.getAge();
    }
}
