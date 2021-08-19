package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.exception.EntityNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDTO;
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

    public Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer =  Repository.getInstance().getCustomerByUsername(customerDTO.getUsername());
        if (customer != null) {
            throw new EntityNotFoundException("Customer with given username already exists - " + customerDTO.getUsername());
        }

        return Repository.getInstance().addCustomer(customerDTO.getUsername(), false, customerDTO.getOrders());
    }

    public Customer removeCustomer(String username) {
        Customer customer = Repository.getInstance().removeCustomer(username);
        if (customer == null) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        return customer;
    }
}
