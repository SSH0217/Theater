package com.Theater.ssh.service;

import com.Theater.domain.Movie;
import com.Theater.ssh.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
//@Transactional
//@RequiredArgsConstructor
//public class MovieService {
//    private final MovieRepository movieRepository;
//
//    public List<Movie> findMovies(){
//        return movieRepository.findALl();
//    }
//    public Movie findOneMovie(String title){
//
//        Movie movie = movieRepository.findByTitle(title);
//
//        return movie;
//    }
//}
