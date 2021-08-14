package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

public class PizzaDeliveryService {

    @Autowired
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService() {}

    public PizzaDeliveryService(PizzeriaService pizzeriaService) {
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
