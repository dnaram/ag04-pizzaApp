package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.entity.Customer;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@org.springframework.stereotype.Service
public class Service {

    private CustomerRepository customerRepository;

    @Autowired
    public Service(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(long id) {
        Optional<Customer> result = customerRepository.findById(id);

        Customer customer = null;
        if (result.isPresent()) {
            customer = result.get();
        } else {
            throw new RuntimeException("Did not find customer id - " + id);
        }

        return customer;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }



}
