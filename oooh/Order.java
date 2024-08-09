package com.example.oooh;

public class Order {

    private float amount ;
    private String type, user;

    public Order(float amount, String type, String user) {
        this.amount = amount;
        this.type = type;
        this.user = user;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
