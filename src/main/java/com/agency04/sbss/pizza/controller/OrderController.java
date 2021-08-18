package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @PostMapping("/delivery/order")
    public ResponseEntity<HttpStatus> placeOrder(@RequestBody DeliveryOrderForm deliveryOrderForm) {


        pizzaDeliveryService.checkAvailablePizzas(deliveryOrderForm);

        pizzaDeliveryService.addOrder(deliveryOrderForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<DeliveryOrderForm> getOrders() {
        return pizzaDeliveryService.getOrders();
    }
}
