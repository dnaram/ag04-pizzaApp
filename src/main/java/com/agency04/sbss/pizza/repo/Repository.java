package com.agency04.sbss.pizza.repo;

import com.agency04.sbss.pizza.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static Repository INSTANCE = null;

    private static List<Customer> customers;

    private Repository() {
        customers = new ArrayList<>();

        addCustomer("user1", true, 12);
        addCustomer("user2", false, 34);
        addCustomer("user3", false, 5);
        addCustomer("user4", true, 17);
        addCustomer("user5", false, 21);
    }

    public static Repository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Repository();

        return INSTANCE;
    }

    public static Customer getCustomerByUsername(String userName) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(userName)) return customer;
        }

        return null;
    }

    public static Customer addCustomer(String username, boolean active, int orders) {
        Customer customer = new Customer(getNewCustomerID(), username, active, orders);
        customers.add(customer);
        return customer;
    }

    public static Customer removeCustomer(String username) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getUsername().equals(username)) {
                customer = c;
                break;
            }
        }

        customers.remove(customer);
        return customer;
    }

    private static int getNewCustomerID() {
        int id = 0;
        for (Customer c : customers) {
            if (c.getId() > id)
                id = c.getId();
        }

        return id+1;
    }
}
