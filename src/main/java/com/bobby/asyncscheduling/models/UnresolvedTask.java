package com.bobby.asyncscheduling.models;

public class UnresolvedTask {

    String body;
    int resolutionAttempts;

    public UnresolvedTask(String body){
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void incrementAttemptCount() {
        this.resolutionAttempts++;
    }

    public int getResolutionAttempts(){
        return this.resolutionAttempts;
    }
}
