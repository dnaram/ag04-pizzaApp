package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.model.dto.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class OrderController {

    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @PostMapping("/order")
    public ResponseEntity<HttpStatus> orderDelivery(@RequestBody DeliveryOrderForm deliveryOrderForm) {

        pizzaDeliveryService.checkAvailablePizzas(deliveryOrderForm);

        pizzaDeliveryService.addOrder(deliveryOrderForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<PizzaOrder> getOrders() {
        return pizzaDeliveryService.getOrders();
    }
}