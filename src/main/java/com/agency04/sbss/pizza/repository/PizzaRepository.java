package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.pizza.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
