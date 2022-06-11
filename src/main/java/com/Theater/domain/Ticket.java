package com.Theater.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long id;
    private boolean isCanceled;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "HALL_ID")
    private Hall hall;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
}
