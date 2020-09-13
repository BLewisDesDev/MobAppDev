package com.example.ass2;

import java.io.Serializable;

public class Task {

    static int counter = 0;
    int t_id;
    String taskName;
    String location;
    boolean status;
    boolean isComplete;

    public Task(String tn, String l){
        this.t_id = counter;
        this.taskName = tn;
        this.location = l;
        this.isComplete = false;
        counter++;
    }

    @Override
    public String toString() {
        return "Task{" +
                "t_id=" + t_id +
                ", taskName='" + taskName + '\'' +
                ", location='" + location + '\'' +
                ", status=" + status +
                '}';
    }

    public String getTaskName() {
        return taskName + " ";
    }

    public String getLocation() {
        return location + " ";
    }

}