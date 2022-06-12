package com.Theater.ssh.repository;

import com.Theater.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepositoryCustom extends JpaRepository<Ticket, Long> {
    //List<Ticket> findAllByScreen_t(Long id);
}
