package com.bobby.asyncscheduling.components;

import com.bobby.asyncscheduling.models.UnresolvedTask;

import java.util.concurrent.*;

public class StaticObjects {

    public static BlockingQueue<UnresolvedTask> taskAwaitingResolution = new LinkedBlockingQueue<>();
    public static BlockingQueue<UnresolvedTask> tasksWeyGetWahala = new LinkedBlockingQueue<>();
}
