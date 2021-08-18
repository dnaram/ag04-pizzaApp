package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.MenuItem;
import com.agency04.sbss.pizza.model.OrderItem;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @PostMapping("/delivery/order")
    public ResponseEntity orderDelivery(@RequestBody DeliveryOrderForm deliveryOrderForm) {

        pizzaDeliveryService.checkAvailablePizzas(deliveryOrderForm);

        pizzaDeliveryService.addOrder(deliveryOrderForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<DeliveryOrderForm> getOrders() {
        return pizzaDeliveryService.getOrders();
    }
}
