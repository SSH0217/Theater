package com.Theater.rhg.Repository;

import com.Theater.domain.Screen;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ScreenRepository {
    @PersistenceContext
    EntityManager em;
    public void save(Screen screen){
        em.persist(screen);
    }
}
