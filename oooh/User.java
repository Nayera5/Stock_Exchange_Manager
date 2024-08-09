package com.example.oooh;

public class User {

    private String first;
    private String last;
    private String Email;
    private String password;
    private String gender;
    private double balance;


    public User(String f, String l, String e, String p, String g, double b) {
        this.first = f;
        this.last = l;
        this.Email = e;
        this.password = p;
        this.gender = g;
        this.balance = b;

    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}




