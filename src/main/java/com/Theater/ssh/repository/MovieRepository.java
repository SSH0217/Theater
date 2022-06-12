package com.Theater.ssh.repository;

import com.Theater.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findAllById(Long id);
    List<Movie> findByTitleLike(String title);
    List<Movie> findByActorLike(String actor);
}
