package com.Theater.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@NamedEntityGraph(
        name = "price.graph",
        attributeNodes = {
                @NamedAttributeNode("price"),
        }
)
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

//    @JsonIgnore
//    @OneToMany(mappedBy = "screen_t")
//    private Ticket ticket;
    @OneToMany(mappedBy = "screen_t")
    private List<Ticket> tickets = new ArrayList<>();
}
