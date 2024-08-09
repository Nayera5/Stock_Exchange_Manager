package com.example.oooh;

public class Company {

    private float price = 44;
    private int quantity = 6;
    private float open;
    private float close;

    public Company(float price, int quantity , float open,float close) {

        this.price = price;
        this.quantity = quantity;
        this.open = open;
        this.close = close;
    }

    // Getter and setter methods for name, price, quantity, symbol

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getOpen() {
        return open;
    }

    public float getClose() {
        return close;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public void setClose(float close) {
        this.close = close;
    }
}