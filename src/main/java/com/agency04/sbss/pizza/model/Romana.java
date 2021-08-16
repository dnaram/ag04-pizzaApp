package com.agency04.sbss.pizza.model;

public class Romana extends Pizza {

    public Romana() {
        super("Romana", new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.ANCHOVIES,
                PizzaIngredient.CAPERS,
                PizzaIngredient.OREGANO
        });
    }
}
