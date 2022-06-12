package com.Theater.ssh.web;

import com.Theater.domain.Member;
import com.Theater.domain.Movie;
import com.Theater.domain.Review;
import com.Theater.kgc.web.SessionConst;
import com.Theater.ssh.DTO.QuestionDTO;
import com.Theater.ssh.service.MovieService;
import com.Theater.ssh.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
    public String moviePage( @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
            @PathVariable("pageNum") int pageNum,
                            @PathVariable("sortBy") String sortBy, Model model){
        Page<Movie> movies = movieService.findMoviesPage(pageNum, sortBy);

        model.addAttribute("movies", movies);
        model.addAttribute("presentNum", pageNum);
        model.addAttribute("pageNext", movies.hasNext());
        model.addAttribute("pagePre", movies.hasPrevious());
        model.addAttribute("presentSort", sortBy);
        model.addAttribute("loginMember",loginMember);

        return "movie/movie-list";
    }
    @GetMapping("/movie/detail/{id}")
    public String createMovieForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,@PathVariable("id") Long movieId, Model model){
        Movie movie = movieService.findOneMovie(movieId);
        List<Review> reviews = reviewService.findReviews(movieId);
        System.out.println("----------------------------------------");
        System.out.println(movie.getId());
        System.out.println(reviews.size());
        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);
        model.addAttribute("loginMember",loginMember);

        return "movie/movie-detail";
    }
    @GetMapping("/movie/search")
    public String searchMovie(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,@RequestParam("question") String quest, Model model){
        List<Movie> movies = movieService.questionMovie(quest);

        model.addAttribute("movies", movies);
        model.addAttribute("loginMember",loginMember);

        return "/movie/search-result";
    }
}
