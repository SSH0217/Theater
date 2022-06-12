package com.Theater.ssh.web;

import com.Theater.domain.Screen;
import com.Theater.ssh.service.ScreenService2;
import com.Theater.ssh.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class TicketController {
    private final ScreenService2 screenService2;
    private final TicketService ticketService;

    @GetMapping("/tickets/{id}")
    public String bookPage(@PathVariable("id") Long screenId, Model model){
        Screen screen = screenService2.findOneScreen(screenId);

        model.addAttribute("screen", screen);


        return "ticket/ticket-book";
    }
}
