package com.Theater.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Price {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PRICE_ID")
    private Long id;
    private int firstPrice;
    //정량이면 true, 정률이면 false
    private boolean isDose;
    private int policyPrice;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;
}
