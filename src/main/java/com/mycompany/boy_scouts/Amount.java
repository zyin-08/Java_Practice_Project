/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.boy_scouts;

/**
 *
 * @author zyin2
 */
public class Amount {
    
    private double price;
    private String currency;
    

    public Amount(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Amount{" + "price=" + price + ", currency=" + currency + '}';
    }
    
    
    
}
