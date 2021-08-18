package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.model.dto.Size;

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

    public PizzaOrder() {}

    public PizzaOrder(String quantity, Size size) {
        this.quantity = quantity;
        this.size = size;
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
