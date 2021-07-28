package com.agency04.sbss.pizza.model;

public class Carbonara implements Pizza {
    @Override
    public String getName() {
        return "Carbonara";
    }

    @Override
    public PizzaIngredient[] getIngredients() {
        return new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.PARMESAN,
                PizzaIngredient.EGGS,
                PizzaIngredient.BACON
        };
    }
}
