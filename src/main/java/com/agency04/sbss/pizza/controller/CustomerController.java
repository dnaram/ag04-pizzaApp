package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.exception.EntityNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDTO;
import com.agency04.sbss.pizza.repo.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {

        Customer customer =  Repository.getInstance().getCustomerByUsername(username);
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        return customer;
    }

    @PostMapping("")
    public Customer postCustomer(@RequestBody CustomerDTO customerDTO) {
        return Repository.getInstance().addCustomer(customerDTO.getUsername(), false, customerDTO.getOrders());
    }

    @PutMapping("")
    public Customer putCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = Repository.getInstance().getCustomerByUsername(customerDTO.getUsername());
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + customerDTO.getUsername());
        }

        customer.setOrders(customerDTO.getOrders());
        return customer;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String username) {
        Customer customer = Repository.getInstance().removeCustomer(username);
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
