package com.agency04.sbss.pizza.model;

public class Margherita implements Pizza {

    public Margherita() {}

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public PizzaIngredient[] getIngredients() {
        return new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.OREGANO
        };
    }
}
