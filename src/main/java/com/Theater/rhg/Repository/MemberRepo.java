package com.Theater.rhg.Repository;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import com.Theater.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MemberRepo implements MemberRepoInte {
    @Autowired
    EntityManager em;
    @Override
    public Member findOne(String id) {
        System.out.println("--------------------repository------------------------");
        return em.createQuery("select m from Member m where m.loginId=:id", Member.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
