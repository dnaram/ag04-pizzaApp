package com.agency04.sbss.pizza.model;

import java.util.Objects;

public class Customer {

    private int id;
    private String username;
    private boolean active;
    private int orders;

    public Customer(int id, String username, boolean active, int orders) {
        this.id = id;
        this.username = username;
        this.active = active;
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
