package com.agency04.sbss.pizza.entity;

import javax.persistence.*;

@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Column
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
}
