package org.javalearners.chapter4.rest.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

    private int id;
    private double amount;

    public Order() {
    }

    public Order(final int id, final double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
