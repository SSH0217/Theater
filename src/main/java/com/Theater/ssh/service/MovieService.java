package com.Theater.ssh.service;

import com.Theater.domain.Movie;
import com.Theater.ssh.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> findMovies(){
        return movieRepository.findAll();
    }
    public Page<Movie> findMoviesPage(int pageNum, String sortBy){
        PageRequest pageRequest = PageRequest.of(pageNum,5, Sort.by(sortBy).descending());
        return movieRepository.findAll(pageRequest);
    }
    public Movie findOneMovie(Long id){
        Movie movie = movieRepository.findAllById(id);
        return movie;
    }
    public List<Movie> questionMovie(String question){
        List<Movie> titleSearch = movieRepository.findByTitleLike(question);
        List<Movie> actorSearch = movieRepository.findByActorLike(question);
        List<Movie> all = new ArrayList<>();
        all.addAll(titleSearch);
        all.addAll(actorSearch);
        return all;

    }
}
