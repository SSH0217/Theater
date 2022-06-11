package com.Theater.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Theater {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "THEATER_ID")
    private Long id;
    private String name;
}
