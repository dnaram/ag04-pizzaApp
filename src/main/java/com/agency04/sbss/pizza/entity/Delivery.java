package com.agency04.sbss.pizza.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column
    private Date submissionDate;

    @OneToMany(mappedBy = "pizzaOrder")
    private List<PizzaOrder> pizzaOrders;

}
