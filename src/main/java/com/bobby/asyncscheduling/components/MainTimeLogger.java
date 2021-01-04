package com.bobby.asyncscheduling.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MainTimeLogger {

    //@Scheduled(initialDelay = 0, fixedRate = 1000)
    public void displayCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'=================='HH:mm:ss");
        Date now = new Date();
        String dateTime = sdf.format(now);
        System.out.println(dateTime + " on " + Thread.currentThread().getName());

    }
}
