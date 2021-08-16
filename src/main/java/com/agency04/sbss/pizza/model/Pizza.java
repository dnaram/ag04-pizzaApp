package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonPropertyOrder({"name", "ingredients"})
@JsonDeserialize(contentAs= Carbonara.class)
public abstract class Pizza {
    @Builder.Default
    @JsonProperty("name")
    private String name;

    @Builder.Default
    @JsonProperty("ingredients")
    private PizzaIngredient[] ingredients;


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
