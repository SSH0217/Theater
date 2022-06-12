package com.Theater.kgc.repository;

import com.Theater.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaMemberRepository implements MemberRepository{

    @Autowired
    EntityManager em;
    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findOne(String loginId) {
        return em.find(Member.class, loginId);
    }
    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    @Override
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name=:name",
                Member.class)
                .setParameter("name", name)
                .getResultList();
    }

//    @Override
//    public List<Member> findByLoginId(String id) {
//        return null;
//    }
}
