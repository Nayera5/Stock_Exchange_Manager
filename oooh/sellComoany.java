package com.example.oooh;

public class sellComoany {
    private double price;
    private int quantity;
    private float open;
    private float close;

    public sellComoany(double price, int quantity, float open, float close) {
        this.price = price;
        this.quantity = quantity;
        this.open = open;
        this.close = close;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }
}
