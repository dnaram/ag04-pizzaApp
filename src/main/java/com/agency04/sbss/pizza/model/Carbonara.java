package com.agency04.sbss.pizza.model;

public class Carbonara extends Pizza {

    public Carbonara() {
        super("Carbonara", new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.PARMESAN,
                PizzaIngredient.EGGS,
                PizzaIngredient.BACON
        });
    }
}
