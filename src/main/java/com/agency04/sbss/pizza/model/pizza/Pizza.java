package com.agency04.sbss.pizza.model.pizza;

import com.agency04.sbss.pizza.model.PizzaOrder;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ElementCollection(targetClass = Ingredient.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private Set<Ingredient> ingredients;

    @JsonManagedReference
    @OneToMany(mappedBy = "pizza")
    private List<PizzaOrder> orders = new ArrayList<>();

    public Pizza() {}

    public Pizza(String name, Set<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) && Objects.equals(name, pizza.name) && Objects.equals(ingredients, pizza.ingredients) && Objects.equals(orders, pizza.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients, orders);
    }
}
