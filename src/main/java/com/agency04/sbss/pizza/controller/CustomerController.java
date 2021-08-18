package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.repo.Repository;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username) {

        Customer customer =  Repository.getInstance().getCustomerByUsername(username);
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        return customer;
    }

    @PostMapping("/customer")
    public Customer postCustomer(@RequestBody String username) {
        return Repository.getInstance().addCustomer(username, false, 0);
    }

    @PutMapping("/customer")
    public Customer putCustomer(@RequestBody String username, @RequestBody int orders) {
        Customer customer = Repository.getInstance().getCustomerByUsername(username);
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        customer.setOrders(orders);
        return customer;
    }

    @DeleteMapping("customer/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        Customer customer = Repository.getInstance().removeCustomer(username);
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
