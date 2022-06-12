package com.Theater.ssh.service;

import com.Theater.domain.Ticket;
import com.Theater.ssh.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public void bookService(Ticket ticket){
        ticketRepository.book(ticket);
    }
}
