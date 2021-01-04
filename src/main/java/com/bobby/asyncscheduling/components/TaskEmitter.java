package com.bobby.asyncscheduling.components;

import com.bobby.asyncscheduling.models.UnresolvedTask;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Random;

@Component
public class TaskEmitter {
    Random random;
    String[] possibleTasks = {"Task One", "Task Two", "Task Three", "Task Four", "Task Five", "Task Six", "Task Seven",};


    //@Scheduled(initialDelay = 80000, fixedRate = 100)
    public void addRandomTaskToQueue() throws InterruptedException {
        random = new Random();
        int randomIndex = random.nextInt(7);
        String task = possibleTasks[randomIndex];
        System.out.println("Adding "+ task + " to Queue" + " on " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("================== "+ task + " ADDED =====================");

        StaticObjects.taskAwaitingResolution.offer(new UnresolvedTask(task));
    }
}
