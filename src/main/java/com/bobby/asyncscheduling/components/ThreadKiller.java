package com.bobby.asyncscheduling.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ThreadKiller {

    //@Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void killThread(){

        System.out.println("About to kill " + Thread.currentThread().getName());
        Thread.currentThread().stop();
    }
}
