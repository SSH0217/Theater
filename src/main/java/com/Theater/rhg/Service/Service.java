package com.Theater.rhg.Service;

import com.Theater.domain.Member;
import com.Theater.domain.Ticket;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.rhg.Repository.CustomizedTicketRepositoryImpl;
import com.Theater.rhg.Repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class Service {
    private final MemberRepo memberRepo;
    private final CustomizedTicketRepositoryImpl a;
    public List<Ticket> findMembers(String id){
//        System.out.println("--------------------service------------------------");
//        return memberRepo.findOne(id);
        Member member=memberRepo.findOne(id);
        System.out.println("--------------------------------------------");
        return a.findWithMemberJPQL(member.getId());

    }
}
