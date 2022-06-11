package com.Theater.rhg.DTO;

import com.Theater.domain.Member;
import com.Theater.domain.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TicketDTO {
    private boolean isCanceled;
    private String Movie;
    private Long Seat;
}
