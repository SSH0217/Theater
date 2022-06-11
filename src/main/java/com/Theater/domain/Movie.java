package com.Theater.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long id;
    private String title;
    private String actor;
    private String movieGrade;
    private String genre;
    private int runTime;
    private Date openingDate;
    private double ticketingRate;
    private double score;

    @JsonIgnore
    @OneToOne(mappedBy = "movie")
    private Ticket ticket;
}
