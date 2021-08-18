package com.agency04.sbss.pizza.model.pizza;

public class Margherita extends Pizza {

    public Margherita() {
        setName("Margherita");
        setIngredients(new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.OREGANO
        });
    }
}
