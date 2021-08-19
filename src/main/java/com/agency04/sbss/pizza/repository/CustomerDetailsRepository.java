package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.CustomerDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends CrudRepository<CustomerDetails, Long> {
}
