package com.Theater.ssh.web;

import com.Theater.domain.Screen;
import com.Theater.domain.Seat;
import com.Theater.domain.Ticket;
import com.Theater.ssh.service.ScreenService2;
import com.Theater.ssh.service.SeatService;
import com.Theater.ssh.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class TicketController {
    private final ScreenService2 screenService2;
    private final TicketService ticketService;
    private final SeatService seatService;

    @GetMapping("/tickets/{id}")
    public String bookPage(@PathVariable("id") Long screenId, Model model){
        Screen screen = screenService2.findOneScreen(screenId);
//        List<Ticket> tickets = ticketService.getTicketed(screenId);
        List<Seat> seats = seatService.getSeat(screen.getHall().getId());

        model.addAttribute("seats", seats);
//        model.addAttribute("tickets", tickets);

        return "ticket/ticket-book";
    }
}
