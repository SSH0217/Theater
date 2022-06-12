package com.Theater.rhg.Service;

import com.Theater.domain.*;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.rhg.Repository.CustomizedScreenRepositoryImpl;
import com.Theater.rhg.Repository.CustomizedTicketRepositoryImpl;
import com.Theater.rhg.Repository.MemberRepo;
import com.Theater.rhg.Repository.ReviewRepo;
import com.Theater.ssh.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class Service {
    private final MemberRepo memberRepo;
    private final CustomizedTicketRepositoryImpl customizedTicketRepository;
    private final ReviewRepo reviewRepo;
    private final MovieRepository movieRepository;

    public Member findMem(String id){
        System.out.println("--------------------service------------------------");
        return memberRepo.findOne(id);
    }

    public List<Ticket> findMembers(Long id){
        System.out.println("--------------------------------------------");
        return customizedTicketRepository.findWithMemberJPQL(id);

    }
    public void registerReview(Member member,String content,int star,Long movie){
        Review review=new Review();
        String loginI=member.getLoginId();
        Member member1=memberRepo.findOne(loginI);
        review.setMember(member1);
        review.setGrade(star);
        review.setContents(content);
        review.setMovieLike(0);
        Movie m=movieRepository.findAllById(movie);
        review.setMovie(m);
        reviewRepo.save(review);
    }
}
