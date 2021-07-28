package com.agency04.sbss.pizza.model;

public class Romana implements Pizza {
    @Override
    public String getName() {
        return "Romana";
    }

    @Override
    public PizzaIngredient[] getIngredients() {
        return new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.ANCHOVIES,
                PizzaIngredient.CAPERS,
                PizzaIngredient.OREGANO
        };
    }
}
