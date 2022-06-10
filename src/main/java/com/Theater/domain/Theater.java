package com.Theater.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Theater {
    @Id @GeneratedValue
    @Column(name = "THEATER_ID")
    private Long id;
    private String name;
}
