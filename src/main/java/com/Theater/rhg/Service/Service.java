package com.Theater.rhg.Service;

import com.Theater.domain.*;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.rhg.Repository.*;
import com.Theater.ssh.repository.MovieRepository;
import com.Theater.ssh.repository.ReviewRepository;
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
    private final ReviewRepository reviewRepository;
    private final CustomizedReviewRepositoryImpl customizedReviewRepository;
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
        List<Review> rList=reviewRepository.findAllByMovieId(movie);
        double sum=0;
        double num=0;
        for(int i=0;i<rList.size();i++)
        {
            if(rList.get(i).getMovie().getId()==movie)
            {
                sum=sum+rList.get(i).getGrade();
                num=num+1;
            }
        }
        double result=sum/num;
        m.setScore(result);
        reviewRepo.saveM(m);

    }
    public void IlikeComment(Long id){
        Review review=customizedReviewRepository.findWithReviewJPQL2(id);
        review.setMovieLike(review.getMovieLike()+1);
        reviewRepo.save(review);

    }
}
