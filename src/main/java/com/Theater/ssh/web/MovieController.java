package com.Theater.ssh.web;

import com.Theater.domain.Movie;
import com.Theater.ssh.DTO.MovieDTO;
import com.Theater.ssh.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("movie")
    public String itemList(Model model){
        List<Movie> movies = movieService.findMovies();
//        List<MovieDTO> movieList = movies
//                .stream()
//                .map(i-> new MovieDTO((Movie)i))
//                .collect(Collectors.toList());
        model.addAttribute("movies", movies);

        return "movie/movie-list";
    }
    @GetMapping("/movie/detail/{movieId}")
    public String createMovieForm(@PathVariable("movieId") Long movieId, Model model){
        Movie movie = movieService.findOneMovie(movieId);

        model.addAttribute("movie", movie);

        return "/movie/movie-detail";
    }
}
