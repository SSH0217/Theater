package com.Theater.ssh.service;

import com.Theater.domain.Seat;
import com.Theater.ssh.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public List<Seat> getSeat(Long hallId){
        return seatRepository.findAllByHallId(hallId);
    }
}
