package com.agency04.sbss.pizza.model.dto;

public class OrderItem {

    private String name;
    private String quantity;
    private Size size;

    public OrderItem(String name, String quantity, Size size) {
        this.name = name;
        this.quantity = quantity;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
