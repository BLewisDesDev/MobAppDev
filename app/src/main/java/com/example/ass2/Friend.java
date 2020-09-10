package com.example.ass2;

public class Friend {

    static int counter = 0;
    int f_id;
    String firstName;
    String lastName;
    String gender;
    int age;
    String address;

    public Friend (String fn, String ln, String g, int a, String ad){
        f_id = counter;
        firstName = fn;
        lastName = ln;
        gender = g;
        age = a;
        address = ad;
        counter++;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "f_id=" + f_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
