package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.MenuItem;
import com.agency04.sbss.pizza.model.OrderItem;
import com.agency04.sbss.pizza.repo.Repository;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
