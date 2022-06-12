package com.Theater.ssh.web;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import com.Theater.domain.Seat;
import com.Theater.domain.Ticket;
import com.Theater.kgc.dto.MemberForm;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.ssh.service.ScreenService2;
import com.Theater.ssh.service.SeatService;
import com.Theater.ssh.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TicketController {
    private final ScreenService2 screenService2;
    private final TicketService ticketService;
    private final SeatService seatService;

    @GetMapping("/tickets/{id}")
    public String bookPage(@PathVariable("id") Long screenId, Model model){
        TicketDTO ticket = new TicketDTO();
        model.addAttribute("ticket", ticket);
        return "ticket/ticket-book";
    }

    @PostMapping("/ticket/book")
    public String addTicket(@ModelAttribute Ticket form){
        TicketDTO ticket = new TicketDTO();
        ticket.setMovie(form.getScreen_t().getMovie().getTitle());
        ticket.setCanceled(false);
        ticket.setSeat(form.getSeat().getId());
        ticketService.bookService(ticket);
        return "redirect:/";
    }
}
