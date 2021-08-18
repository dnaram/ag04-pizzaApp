package com.agency04.sbss.pizza.model.dto;

import java.util.List;

public class DeliveryOrderForm {

    private String username;
    private List<OrderItem> orderDetails;

    public DeliveryOrderForm(String username, List<OrderItem> orderDetails) {
        this.username = username;
        this.orderDetails = orderDetails;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<OrderItem> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderItem> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
