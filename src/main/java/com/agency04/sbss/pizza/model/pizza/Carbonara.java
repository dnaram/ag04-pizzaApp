package com.agency04.sbss.pizza.model.pizza;

public class Carbonara implements Pizza {

    public Carbonara() {}

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
