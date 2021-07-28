package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;

public class PizzeriaDeliveryService {

    private PizzeriaService pizzeriaService;

    public PizzeriaDeliveryService() {}

    public PizzeriaDeliveryService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public String orderPizza(Pizza pizza) {
        pizzeriaService.makePizza(pizza);
        return String.format("Pizza ordered: %s\nPizzeria: %s", pizza.getName(), pizzeriaService.getName());
    }
}
