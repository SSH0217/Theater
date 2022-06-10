package com.Theater.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Hall {
    @Id @GeneratedValue
    @Column(name = "HALL_ID")
    private Long id;
    @NotNull
    private int hallNum;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "hall")
    private Ticket ticket;
}
