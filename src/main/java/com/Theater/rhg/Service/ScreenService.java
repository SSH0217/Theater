package com.Theater.rhg.Service;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import com.Theater.domain.Ticket;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.rhg.Repository.CustomizedScreenRepositoryImpl;
import com.Theater.rhg.Repository.CustomizedTicketRepositoryImpl;
import com.Theater.rhg.Repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenService {
    private final CustomizedScreenRepositoryImpl customizedScreenRepository;
    public List<Screen> findScreens(){
        System.out.println("-----------------------22---------------------");
        return customizedScreenRepository.findWithScreenJPQL();

    }
}
