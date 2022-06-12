package com.Theater.ssh.web;

import com.Theater.domain.Movie;
//import com.Theater.ssh.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MovieController {
//    private final MovieService movieService;

//    @GetMapping("/movies")
//    public String itemList(Model model){
//        List<Movie> movies = movieService.findMovies();
//
//        return ""
//    }
//    @GetMapping("/movie")
//    public String createMovieForm(Model model){
//        Movie movie = movieService.findOneMovie();
//
//        model.addAttribute("movie", movie);
//
//        return "/movie/movie-detail";
//    }
}
