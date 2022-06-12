package com.Theater.ssh.repository;

import com.Theater.domain.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository2 extends JpaRepository<Screen, Long> {
    Screen findAllById(Long id);
}
