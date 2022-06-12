package com.Theater.rhg.Repository;

import com.Theater.domain.Review;
import com.Theater.domain.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomizedReviewRepositoryImpl extends JpaRepository<Review,Long> {
    @Query("SELECT r FROM Review r where r.id=:id")
    Review findWithReviewJPQL2(@Param("id")  Long id);
}
