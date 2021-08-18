package com.agency04.sbss.pizza.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "pizzaOrder")
    private List<PizzaOrder> pizzaOrders;
}
