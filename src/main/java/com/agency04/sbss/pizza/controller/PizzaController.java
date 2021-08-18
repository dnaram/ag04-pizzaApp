package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.MenuItem;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PizzaController {

    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @GetMapping("/pizzeria")
    public PizzeriaService getPizzeria() {

        return pizzaDeliveryService.getPizzeriaService();
    }

    @GetMapping("/pizzeria/menu")
    public MenuItem[] getMenu() {

        return pizzaDeliveryService.getPizzeriaService().getMenu();
    }

}
