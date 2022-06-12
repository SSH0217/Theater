package com.Theater.ssh.service;

import com.Theater.domain.Ticket;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.ssh.repository.TicketRepository;
import com.Theater.ssh.repository.TicketRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketRepositoryCustom ticketRepositoryCustom;

    public void bookService(Ticket ticket){
        ticketRepository.book(ticket);
    }

//    public List<Ticket> getTicketed(Long id){
//        return ticketRepositoryCustom.findAllByScreen_t(id);
//    }
}
