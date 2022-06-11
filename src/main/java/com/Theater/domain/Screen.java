package com.Theater.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Screen {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long id;
    private Date startTime;
    private Date endTime;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "HALL_ID")
    private Hall hall;

    @JsonIgnore
    @OneToOne(mappedBy = "screen")
    private Price price;

    @JsonIgnore
    @OneToOne(mappedBy = "screen_t")
    private Ticket ticket;
}
