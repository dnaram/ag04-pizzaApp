package com.agency04.sbss.pizza.model.pizza;

import com.agency04.sbss.pizza.model.PizzaOrder;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    @Type(type = "com.agency04.sbss.pizza.model.pizza.Ingredient")
    private Ingredient[] ingredients;

    @JsonManagedReference
    @OneToMany(mappedBy = "pizza")
    private List<PizzaOrder> orders = new ArrayList<>();

    public Pizza() {}

    public Pizza(String name, Ingredient[] ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PizzaOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PizzaOrder> orders) {
        this.orders = orders;
    }
}
