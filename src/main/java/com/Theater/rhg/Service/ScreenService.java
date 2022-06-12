package com.Theater.rhg.Service;

import com.Theater.domain.Screen;
import com.Theater.rhg.Repository.CustomizedScreenRepositoryImpl;
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
//    public void registerPrice(Long screenId,boolean policy,int amount){
//        System.out.println("-----------------------22---------------------");
//        Screen screen= customizedScreenRepository.findWithScreenJPQL2(screenId);
//        Price price=Price.createPrice(screen,policy,amount,10000);
//        priceRepo.save(price);
//    }
}
