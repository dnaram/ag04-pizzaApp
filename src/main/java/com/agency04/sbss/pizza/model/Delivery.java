package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_username")
    private Customer customer;

    @Column
    private Date submissionDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "delivery_id")
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();

    public Delivery() {}

    public Delivery(Date submissionDate, Customer customer, List<PizzaOrder> pizzaOrders) {
        this.customer = customer;
        this.submissionDate = submissionDate;
        this.pizzaOrders = pizzaOrders;
    }

    public Delivery(Date submissionDate, Customer customer) {
        this.submissionDate = submissionDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
}
