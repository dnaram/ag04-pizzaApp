package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.model.dto.Size;
import com.agency04.sbss.pizza.model.pizza.Pizza;

import javax.persistence.*;

@Entity
@Table
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String quantity;

    @Column
    private Size size;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    private Pizza pizza;

    public PizzaOrder() {}

    public PizzaOrder(String quantity, Size size) {
        this.quantity = quantity;
        this.size = size;
    }

    public PizzaOrder(String quantity, Size size, Pizza pizza) {
        this.quantity = quantity;
        this.size = size;
        this.pizza = pizza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
