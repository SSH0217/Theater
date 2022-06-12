package com.Theater.rhg.DTO;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import com.Theater.domain.Seat;
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
    private String movie;
    private int hall;
    public ScreenDTO(Screen screen){
        this.id = screen.getId();
        this.start=screen.getStartTime();
        this.end=screen.getEndTime();
        this.movie=screen.getMovie().getTitle();
        this.hall=screen.getHall().getHallNum();
    }
}
