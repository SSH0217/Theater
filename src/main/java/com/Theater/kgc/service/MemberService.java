package com.Theater.kgc.service;

import com.Theater.domain.Member;
import com.Theater.kgc.repository.SpringDataMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final SpringDataMemberRepository memberRepository;

    public Long join(Member member){
        System.out.println(member.getName());
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByLoginId(member.getLoginId());
        if(findMember!=null){
            throw new IllegalStateException("이미 존재하는 아이디입니다");
        }
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Member findOne(Long MemberId){
        return memberRepository.findById(MemberId).get();
    }
}
