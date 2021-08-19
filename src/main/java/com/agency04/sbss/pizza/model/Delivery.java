package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference
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

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id) && Objects.equals(customer, delivery.customer) && Objects.equals(submissionDate, delivery.submissionDate) && Objects.equals(pizzaOrders, delivery.pizzaOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, submissionDate, pizzaOrders);
    }
}
