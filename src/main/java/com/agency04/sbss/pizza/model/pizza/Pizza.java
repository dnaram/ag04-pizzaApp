package com.agency04.sbss.pizza.model.pizza;

import javax.persistence.*;

@Entity
@Table
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    private PizzaIngredient[] ingredients;

    public Pizza() {}

    public Pizza(String name, PizzaIngredient[] ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaIngredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(PizzaIngredient[] ingredients) {
        this.ingredients = ingredients;
    }
}
