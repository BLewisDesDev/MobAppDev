package com.example.ass2;

public class Task {

    static int counter = 0;
    int t_id;
    String taskName;
    String location;
    boolean status;

    public Task(String tn, String l){
        this.t_id = counter;
        this.taskName = tn;
        this.location = l;
        this.status = false;
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
        return taskName;
    }

    public String getLocation() {
        return location;
    }
}