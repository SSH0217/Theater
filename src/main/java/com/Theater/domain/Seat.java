package com.Theater.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Seat {
    @Id @GeneratedValue
    @Column(name = "SEAT_ID")
    private Long id;
    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "HALL_ID")
    private Hall hall;

    @JsonIgnore
    @OneToOne(mappedBy = "seat")
    private Ticket ticket;
}
