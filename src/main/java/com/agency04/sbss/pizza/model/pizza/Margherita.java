package com.agency04.sbss.pizza.model.pizza;

public class Margherita extends Pizza {

    public Margherita() {
        setName("Margherita");
        setIngredients(new Ingredient[]{Ingredient.TOMATO_SAUCE,
                Ingredient.MOZZARELLA,
                Ingredient.OREGANO
        });
    }
}
