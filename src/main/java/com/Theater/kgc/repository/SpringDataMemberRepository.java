package com.Theater.kgc.repository;

import com.Theater.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataMemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
   // List<Member> findByLoginId(String id);
    Member findByLoginId(String id);


    @EntityGraph(value = "member_comment_order", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT m FROM Member m")
    List<Member> findMemberWithCommentAndOrder();

    @EntityGraph(value = "member_comment", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT m FROM Member m")
    List<Member> findMemberWithComment();

    @EntityGraph(value = "member_order", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT m FROM Member m")
    List<Member> findMemberWithOrder();
}
