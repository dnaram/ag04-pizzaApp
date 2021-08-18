package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
