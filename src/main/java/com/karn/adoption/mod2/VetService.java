package com.karn.adoption.mod2;

import com.karn.adoption.common.CustomEvent;
import com.karn.adoption.common.DogAdoptionEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
class VetService {

   @ApplicationModuleListener
    void logEventReceived(CustomEvent event) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Hello "+event+" "+Thread.currentThread().getName());
    }

    @ApplicationModuleListener
    void logDogEventReceived(DogAdoptionEvent event) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Hello, Got "+event+" "+Thread.currentThread().getName());
    }

}
