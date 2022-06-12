package com.Theater.ssh.service;

import com.Theater.domain.Screen;
import com.Theater.ssh.repository.ScreenRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenService2 {
    private final ScreenRepository2 screenRepository2;

    public Screen findOneScreen(Long id){
        Screen screen = screenRepository2.findAllById(id);
        return screen;
    }
}
