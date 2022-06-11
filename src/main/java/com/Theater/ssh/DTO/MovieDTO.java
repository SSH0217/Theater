package com.Theater.ssh.DTO;

import com.Theater.domain.Movie;

import java.util.Date;

public class MovieDTO {
    private Long id;
    private String title;
    private String actor;
    private String movieGrade;
    private String genre;
    private int runTime;
    private Date openingDate;
    private double ticketingRate;
    private double score;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.actor = movie.getActor();
        this.movieGrade = movie.getMovieGrade();
        this.genre = movie.getGenre();
        this.runTime = movie.getRunTime();
        this.openingDate = movie.getOpeningDate();
        this.ticketingRate = movie.getTicketingRate();
        this.score = movie.getScore();
    }
}
