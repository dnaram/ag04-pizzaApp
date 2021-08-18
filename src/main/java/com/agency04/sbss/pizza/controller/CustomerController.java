package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.entity.Customer;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;
    
    @GetMapping("/customer/{username}")
    private Customer getCustomer(@PathVariable("username") String username) {
        return pizzaDeliveryService.getCustomerByUsername();
    }
    
    @DeleteMapping("/customer/{username}")
    private void deleteCustomer(@PathVariable("username") String username) {
        pizzaDeliveryService.delete(username);
    }
    
    @PostMapping("/customer")
    private int saveCustomer(@RequestBody Customer customer) {
        pizzaDeliveryService.saveOrUpdate(customer);
        return customer.getId();
    }
    
    @PutMapping("/customer")
    private void addCustomer(@RequestBody Customer customer) {
        // TODO: 18. 08. 2021. add put functionality 
    }
    
}
