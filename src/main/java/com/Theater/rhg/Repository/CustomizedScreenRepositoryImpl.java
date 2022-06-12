package com.Theater.rhg.Repository;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomizedScreenRepositoryImpl extends JpaRepository<Screen,Long> {

    @Query("SELECT s FROM Screen s join fetch s.movie join fetch s.hall")
    List<Screen> findWithScreenJPQL();


    @Query("SELECT s FROM Screen s where s.id=:id")
    Screen findWithScreenJPQL2(@Param("id")  Long id);

}