package com.bobby.asyncscheduling.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class SpringResuscitation {

    @Scheduled(initialDelay = 1000, fixedDelay = 1)
    public void resilientThread() throws InterruptedException {

        System.out.println("Started Resilient Thread");
        int iterationCount = 0;
        while (true){


            System.out.println("Running resilient thread, iteration count: " + iterationCount);
            new TaskEmitter().addRandomTaskToQueue();
            Thread.sleep(2000);
            if (iterationCount < 8){
                iterationCount++;
            }else {
                //Simulates unstable threads
                Thread.currentThread().stop();
            }

        }
    }
}
