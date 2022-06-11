package com.Theater.rhg.Repository;

import com.Theater.domain.Ticket;
import com.Theater.rhg.DTO.TicketDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomizedTicketRepositoryImpl extends JpaRepository<Ticket, Long> {

        //@EntityGraph(value = "ticket.member.graph", type = EntityGraph.EntityGraphType.LOAD)
        @Query("SELECT t FROM Ticket t join fetch t.member join fetch t.seat join fetch t.screen_t where t.member.id=:id")
        List<Ticket> findWithMemberJPQL(@Param("id")  Long id);

}