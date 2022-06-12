package com.Theater.rhg.Service;

import com.Theater.domain.Screen;
import com.Theater.rhg.Repository.CustomizedScreenRepositoryImpl;
import com.Theater.rhg.Repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenService {
    private final CustomizedScreenRepositoryImpl customizedScreenRepository;
    private final ScreenRepository screenRepository;

    public List<Screen> findScreens(){
        System.out.println("-----------------------22---------------------");
        return customizedScreenRepository.findWithScreenJPQL();

    }
    public void updatePolicy(Long screenId,boolean policy,int amount){
        System.out.println("-----------------------22---------------------");
        Screen screen= customizedScreenRepository.findWithScreenJPQL2(screenId);
        screen.setDose(policy);
        screen.setPolicyPrice(amount);
        screenRepository.save(screen);
    }
}
