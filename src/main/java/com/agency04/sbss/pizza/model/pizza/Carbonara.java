package com.agency04.sbss.pizza.model.pizza;

public class Carbonara extends Pizza {

    public Carbonara() {
        setName("Carbonara");
        setIngredients(new Ingredient[]{ Ingredient.TOMATO_SAUCE,
                Ingredient.MOZZARELLA,
                Ingredient.PARMESAN,
                Ingredient.EGGS,
                Ingredient.BACON
        });
    }
}
