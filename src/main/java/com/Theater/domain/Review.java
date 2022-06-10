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
public class Review {
    @Id @GeneratedValue
    @Column(name = "REVIEW_ID")
    private Long id;
    private int grade;
    private String contents;
    private int movieLike;
}
