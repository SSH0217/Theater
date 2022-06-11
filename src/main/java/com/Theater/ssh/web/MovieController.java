package com.Theater.ssh.web;

import com.Theater.ssh.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    //@GetMapping("/movie/")
}
