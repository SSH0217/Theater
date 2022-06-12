package com.Theater.kgc.web;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import com.Theater.rhg.Service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
public class ScreenController {
    private final ScreenService screenService;

    @GetMapping("/screen-list")
    public String screenList(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
            Model model){
        List<Screen> screens = screenService.findScreens();

        model.addAttribute("screens", screens);
        model.addAttribute("loginMember",loginMember);

        return "screens/screen-list";
    }
//    @GetMapping("/movie/{sortBy}/{pageNum}")
//    public String moviePage(@PathVariable("pageNum") int pageNum,
//                            @PathVariable("sortBy") String sortBy, Model model){
//        Page<Movie> movies = movieService.findMoviesPage(pageNum, sortBy);
//
//        model.addAttribute("movies", movies);
//        model.addAttribute("presentNum", pageNum);
//        model.addAttribute("pageNext", movies.hasNext());
//        model.addAttribute("pagePre", movies.hasPrevious());
//        model.addAttribute("presentSort", sortBy);
//
//        return "movie/movie-list";
//    }
//
//    @GetMapping("/movie/detail/{id}")
//    public String createMovieForm(@PathVariable("id") Long movieId, Model model){
//        Movie movie = movieService.findOneMovie(movieId);
//        List<Review> reviews = reviewService.findReviews(movieId);
//        model.addAttribute("movie", movie);
//        model.addAttribute("reviews", reviews);
//
//        return "movie/movie-detail";
//    }
}
