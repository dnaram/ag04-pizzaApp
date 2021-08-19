package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.exception.EntityNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDTO;
import com.agency04.sbss.pizza.repo.Repository;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {

        return customerService.getCustomerByUsername(username);
    }

    @PostMapping("")
    public Customer postCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("")
    public Customer putCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.getCustomerByUsername(customerDTO.getUsername());

        customer.setOrders(customerDTO.getOrders());
        return customer;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String username) {
        Customer customer = customerService.getCustomerByUsername(username);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
