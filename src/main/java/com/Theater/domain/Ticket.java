package com.Theater.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NamedEntityGraph(
        name = "ticket.screen.movie.graph",
        attributeNodes = {
                @NamedAttributeNode("seat"),
                @NamedAttributeNode(value = "screen_t", subgraph = "screen_t-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "screen_t-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("movie")
                        }
                )
        }
)

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long id;
    private boolean isCanceled;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen_t;
}
