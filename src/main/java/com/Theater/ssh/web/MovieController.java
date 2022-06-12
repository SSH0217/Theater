package com.Theater.ssh.web;

import com.Theater.domain.Movie;
import com.Theater.domain.Review;
import com.Theater.ssh.service.MovieService;
import com.Theater.ssh.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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
    public String movieList(Model model){
        List<Movie> movies = movieService.findMovies();

        model.addAttribute("movies", movies);

        return "movie/movie-list";
    }
    @GetMapping("/movies")
    public String moviePage(Model model){
        Page<Movie> movies = movieService.findMoviesPage(0);

        model.addAttribute("movies", movies);
        model.addAttribute("pageNum", movies.stream().count());

        return "movie/movie-list";
    }
    @GetMapping("/movie/detail/{id}")
    public String createMovieForm(@PathVariable("id") Long movieId, Model model){
        Movie movie = movieService.findOneMovie(movieId);
        List<Review> reviews = reviewService.findReviews(movieId);
        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);

        return "movie/movie-detail";
    }
}
