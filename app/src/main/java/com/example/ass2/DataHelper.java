package com.example.ass2;

import java.util.ArrayList;

public class DataHelper {

    ArrayList<Task> taskArray = new ArrayList<Task>();
    ArrayList<Friend> friendsArray = new ArrayList<Friend>();

    public DataHelper() {

        Task t = new Task("Do stuff" , "Here");
        Task a = new Task("Do stuff" , "Here");
        Task s = new Task("Do stuff" , "Here");
        Task k = new Task("Do stuff" , "Here");

        taskArray.add(t);
        taskArray.add(a);
        taskArray.add(s);
        taskArray.add(k);

        ArrayList<Friend> friendsArray = new ArrayList<Friend>();

        Friend F = new Friend("A", "G", "M", 10, "S");
        Friend r = new Friend("B", "H", "N", 10, "T");
        Friend I = new Friend("C", "I", "O", 10, "U");
        Friend E = new Friend("D", "J", "P", 10, "V");
        Friend N = new Friend("E", "K", "Q", 10, "W");
        Friend D = new Friend("F", "L", "R", 10, "X");

        friendsArray.add(F);
        friendsArray.add(r);
        friendsArray.add(I);
        friendsArray.add(E);
        friendsArray.add(N);
        friendsArray.add(D);

    }

    public ArrayList<Friend> getFriendsArray() {
        return friendsArray;
    }

    public ArrayList<Task> getTaskArray() {
        return taskArray;
    }
}
