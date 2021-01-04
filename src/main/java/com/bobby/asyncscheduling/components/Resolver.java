package com.bobby.asyncscheduling.components;

import com.bobby.asyncscheduling.models.UnresolvedTask;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Resolver {

    @Scheduled(initialDelay = 30000, fixedRate = 500)
    public void resolveTaskInQueue() throws InterruptedException {

        System.out.println("Checking Queue for tasks"+ " on " + Thread.currentThread().getName());
        System.out.println("==============================================");

        Iterator<UnresolvedTask> iterator = StaticObjects.taskAwaitingResolution.iterator();

        if(iterator.hasNext()){
            StaticObjects.taskAwaitingResolution.iterator().next().incrementAttemptCount();
            UnresolvedTask unresolvedTask = iterator.next();
            System.out.println("Resolving a task from Queue"+ " on " + Thread.currentThread().getName() + " ATTEMPT: " + unresolvedTask.getResolutionAttempts());
            System.out.println("==============================================");

            if (unresolvedTask.getResolutionAttempts() > 1 && unresolvedTask.getResolutionAttempts()< 4){
                System.out.println("POTENTIAL PROBLEMATIC TASK");
            }else if (unresolvedTask.getResolutionAttempts() == 4){
                StaticObjects.tasksWeyGetWahala.offer(unresolvedTask);
                iterator.remove();

                System.out.println("ADDED PROBLEMATIC TASK " + unresolvedTask.getBody() + " TO WAHALA QUEUE");
                System.out.println("NUMBER OF TASKS ON WAHALA QUEUE IS: " + StaticObjects.tasksWeyGetWahala.size());
                return;
            }
            String taskBeingResolved = unresolvedTask.getBody();

            System.out.println("Task being resolved is :" + taskBeingResolved+ " on " + Thread.currentThread().getName());
            System.out.println("==============================================");

            long value = 0;
            //Simulating time consuming operation
            for (long i = 0; i < 10000000000L; i++){
                value++;
            }

            if(taskBeingResolved.equals("Task Six")){
                Thread.currentThread().stop();
            }

            iterator.remove();

            System.out.println(StaticObjects.taskAwaitingResolution.size() + " tasks left in Queue."+ " on " + Thread.currentThread().getName());
            System.out.println("==============================================");

        }


    }
}
