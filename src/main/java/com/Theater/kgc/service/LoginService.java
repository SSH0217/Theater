package com.Theater.kgc.service;

import com.Theater.domain.Member;
import com.Theater.kgc.repository.MemberRepository;
import com.Theater.kgc.repository.SpringDataMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final SpringDataMemberRepository memberRepository;
    public Member login(String loginId, String password){
        Member findMember = memberRepository.findByLoginId(loginId);
        if(findMember !=null && findMember.getPassword().equals(password)){
            return findMember;
        }else{
            return null;
        }
    }
}
