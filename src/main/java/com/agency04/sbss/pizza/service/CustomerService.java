package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.exception.EntityNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.model.dto.CustomerForm;
import com.agency04.sbss.pizza.repository.CustomerDetailsRepository;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public Customer getCustomerByUsername(String username) {
        Optional<Customer> result = customerRepository.findById(username);
        if (result.isEmpty()) {
            throw new EntityNotFoundException("Can not find customer with username - " + username);
        }

        return result.get();
    }

    public Customer saveCustomer(CustomerForm customerForm) {
        Optional<Customer> result = customerRepository.findById(customerForm.getUsername());
        if (result.isPresent()) {
            throw new EntityNotFoundException("Customer with given username already exists - " + customerForm.getUsername());
        }

        CustomerDetails customerDetails = new CustomerDetails(customerForm.getFirstname(), customerForm.getLastname(), customerForm.getPhone());
        customerDetailsRepository.save(customerDetails);

        Customer customer = new Customer(customerForm.getUsername());
        customer.setCustomerDetails(customerDetails);
        customerRepository.save(customer);

        return customer;
    }

    public void delete(String username) {
        customerRepository.deleteById(username);
    }

    public void update(Customer customer, CustomerForm customerForm) {
        CustomerDetails cd = customer.getCustomerDetails();
        cd.setFirstName(customerForm.getFirstname());
        cd.setLastName(customerForm.getLastname());
        cd.setPhone(customerForm.getPhone());
        customerDetailsRepository.save(cd);
    }
}
