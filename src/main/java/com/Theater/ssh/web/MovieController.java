package com.Theater.ssh.web;

import com.Theater.domain.Movie;
import com.Theater.domain.Review;
import com.Theater.ssh.service.MovieService;
import com.Theater.ssh.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final ReviewService reviewService;

    @GetMapping("/movie")
    public String itemList(Model model){
        List<Movie> movies = movieService.findMovies();

        model.addAttribute("movies", movies);

        return "movie/movie-list";
    }
    @GetMapping("/movie/detail/{movieId}")
    public String createMovieForm(@PathVariable("movieId") Long movieId, Model model){
        Movie movie = movieService.findOneMovie(movieId);
        List<Review> reviews = reviewService.findReviews(movieId);
        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);

        return "/movie/movie-detail";
    }
}
