package com.Theater.kgc.repository;

import com.Theater.domain.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findOne(String id);
    List<Member> findAll();
    List<Member> findByName(String name);
}
