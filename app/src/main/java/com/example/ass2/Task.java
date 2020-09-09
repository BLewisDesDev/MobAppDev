package com.example.ass2;

public class Task {

    static int counter = 0;
    int t_id;
    String taskName;
    String location;
    boolean status;

    public Task(String tn, String l){
        t_id = counter;
        taskName = tn;
        location = l;
        status = false;
        counter++;
    }
}