package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.exception.EntityNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.repo.Repository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomerByUsername(String username) {
        Customer customer =  Repository.getInstance().getCustomerByUsername(username);
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        return customer;
    }
}
