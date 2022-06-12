package com.Theater.rhg.Repository;

import com.Theater.domain.Member;
import com.Theater.domain.Movie;
import com.Theater.domain.Review;
import com.Theater.domain.Screen;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReviewRepo {
    @PersistenceContext
    EntityManager em;
    public void save(Review review){
        em.persist(review);
    }
    public void saveM(Movie movie){
        em.persist(movie);
    }
}
