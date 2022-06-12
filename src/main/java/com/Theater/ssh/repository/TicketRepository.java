package com.Theater.ssh.repository;

import com.Theater.domain.Ticket;
import com.Theater.rhg.DTO.TicketDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TicketRepository {
    @PersistenceContext
    EntityManager em;

    public void book(TicketDTO ticket){
        if(ticket.getId() == null){
            em.persist(ticket);
        }
        else{
            em.persist(ticket);
        }
    }
}
