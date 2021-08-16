package com.agency04.sbss.pizza.model;

public class Margherita extends Pizza {

    public Margherita() {
        super("Margherita", new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.OREGANO
        });
    }
}
