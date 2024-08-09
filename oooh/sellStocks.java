package com.example.oooh;


public class sellStocks {


    private float price ;
    private int quantity ;

    public sellStocks(float price, int quantity ) {

        this.price = price;
        this.quantity = quantity;

    }

    // Getter and setter methods for name, price, quantity, symbol

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
