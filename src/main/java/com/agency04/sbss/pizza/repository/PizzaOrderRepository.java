package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.PizzaOrder;
import org.springframework.data.repository.CrudRepository;

public interface PizzaOrderRepository extends CrudRepository<PizzaOrder, Long> {
}
