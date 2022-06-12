package com.Theater.rhg.DTO;

import com.Theater.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDTO {
    private Long id;
    private Date start;
    private Date end;
    private Movie movie;
    private Hall hall;
    private int firstPrice;
    private boolean isDose;
    private int policyPrice;
    public ScreenDTO(Screen screen){
        this.id = screen.getId();
        this.start=screen.getStartTime();
        this.end=screen.getEndTime();
        this.movie=screen.getMovie();
        this.hall=screen.getHall();
        this.firstPrice= screen.getFirstPrice();
        this.isDose=screen.isDose();
        this.policyPrice= screen.getPolicyPrice();
    }
}
