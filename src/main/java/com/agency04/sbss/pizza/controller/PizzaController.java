package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.dto.MenuItem;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.pizzeria.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzaController {

    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @GetMapping
    public PizzeriaService getPizzeria() {

        return pizzaDeliveryService.getPizzeriaService();
    }

    @GetMapping("/menu")
    public MenuItem[] getMenu() {
        return pizzaDeliveryService.getPizzeriaService().getMenu();
    }

}