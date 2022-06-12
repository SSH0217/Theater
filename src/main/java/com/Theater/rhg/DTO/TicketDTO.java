package com.Theater.rhg.DTO;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import com.Theater.domain.Seat;
import com.Theater.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private Long id;
    private boolean isCanceled;
    private String Movie;
    private Long Seat;
    public TicketDTO(Ticket ticket){
        this.id=ticket.getId();
        this.isCanceled=ticket.isCanceled();
        this.Movie=ticket.getScreen_t().getMovie().getTitle();
        this.Seat=ticket.getSeat().getId();
    }
}
