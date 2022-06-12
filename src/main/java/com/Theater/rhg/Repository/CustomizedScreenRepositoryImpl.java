package com.Theater.rhg.Repository;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomizedScreenRepositoryImpl extends JpaRepository<Screen,Long> {

    @EntityGraph(value = "price.graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT s FROM Screen s join fetch s.movie join fetch s.hall")
    List<Screen> findWithScreenJPQL();

}