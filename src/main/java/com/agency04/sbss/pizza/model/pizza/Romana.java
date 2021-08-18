package com.agency04.sbss.pizza.model.pizza;

public class Romana implements Pizza {

    public Romana() {}

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
