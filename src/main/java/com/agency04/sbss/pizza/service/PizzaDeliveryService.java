package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.Pizza;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;

    private List<DeliveryOrderForm> orders;

    @PostConstruct
    private void initialize() {
        orders = new ArrayList<>();
    }

    public PizzaDeliveryService() {}

    public PizzaDeliveryService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
    }

    public String orderPizza(Pizza pizza) {
        pizzeriaService.makePizza(pizza);
        return String.format("Pizza ordered: %s\nPizzeria: %s", pizza.getName(), pizzeriaService.getName());
    }

    public void addOrder(DeliveryOrderForm order) {
        orders.add(order);
    }

    public List<DeliveryOrderForm> getOrders() {
        return orders;
    }
}
