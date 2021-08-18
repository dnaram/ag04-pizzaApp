package com.agency04.sbss.pizza.model.pizza;

public class Romana extends Pizza {

    public Romana() {
        setName("Romana");
        setIngredients(new PizzaIngredient[]{PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.ANCHOVIES,
                PizzaIngredient.CAPERS,
                PizzaIngredient.OREGANO
        });
    }
}
