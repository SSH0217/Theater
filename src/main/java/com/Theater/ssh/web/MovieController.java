package com.Theater.ssh.web;

import com.Theater.domain.Member;
import com.Theater.domain.Movie;
import com.Theater.domain.Review;
import com.Theater.kgc.web.SessionConst;
import com.Theater.ssh.service.MovieService;
import com.Theater.ssh.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final ReviewService reviewService;

    @GetMapping("/movies")
    public String movieList(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,Model model){
        List<Movie> movies = movieService.findMovies();

        model.addAttribute("movies", movies);

        return "movie/movie-list";
    }
    @GetMapping("/movie/{sortBy}/{pageNum}")
    public String moviePage(@PathVariable("pageNum") int pageNum,
                            @PathVariable("sortBy") String sortBy, Model model){
        Page<Movie> movies = movieService.findMoviesPage(pageNum, sortBy);

        model.addAttribute("movies", movies);
        model.addAttribute("presentNum", pageNum);
        model.addAttribute("pageNext", movies.hasNext());
        model.addAttribute("pagePre", movies.hasPrevious());
        model.addAttribute("presentSort", sortBy);

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
