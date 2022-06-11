package com.Theater.rhg.Service;

import com.Theater.domain.Member;
import com.Theater.rhg.Repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class Service {
    private final MemberRepo memberRepo;
    public Member findMembers(String id){
        System.out.println("--------------------service------------------------");
        return memberRepo.findOne(id);
    }
}
