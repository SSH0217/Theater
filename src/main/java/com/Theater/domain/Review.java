package com.Theater.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long id;
    private int grade;
    private String contents;
    private int movieLike;
}
