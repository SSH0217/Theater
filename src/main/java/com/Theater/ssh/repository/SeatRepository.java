package com.Theater.ssh.repository;

import com.Theater.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByHallId(Long id);
}
