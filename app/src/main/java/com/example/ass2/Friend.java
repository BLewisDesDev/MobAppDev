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
        this.f_id = counter;
        this.firstName = fn;
        this.lastName = ln;
        this.gender = g;
        this.age = a;
        this.address = ad;
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
